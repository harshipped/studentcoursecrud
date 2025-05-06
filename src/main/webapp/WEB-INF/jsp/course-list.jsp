<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course List</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <h1>All Courses</h1>
    <a href="/courses/new">
        <button>Add New Course</button> </a>
    <a href="${pageContext.request.contextPath}/students/list">
        <button>Home</button>
    </a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th class="actions">Actions</th>
        </tr>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/courses/edit/${course.id}"><button>Update</button></a> |
                    <a href="${pageContext.request.contextPath}/courses/delete/${course.id}"
                       onclick="return confirm('Are you sure you want to delete this course?');"><button class="delete">Delete</button></a>
                </td>
                
            </tr>
        </c:forEach>
    </table>
</body>
</html>
