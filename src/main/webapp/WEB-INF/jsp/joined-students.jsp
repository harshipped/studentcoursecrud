<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Students with Courses</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
<div class="table-container">
    <h2>Students with Enrolled Courses</h2>
    <a href="${pageContext.request.contextPath}/students/list">
        <button>Home</button>
    </a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Courses</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>
                    <c:forEach var="course" items="${student.courses}">
                        ${course.name}<c:if test="${!fn:endsWith(course.name, ',')}">, </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    
</div>
</body>
</html>
