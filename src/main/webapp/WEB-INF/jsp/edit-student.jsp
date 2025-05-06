<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
<div class="form-container">
    <h2>Edit Student</h2>
    <div class="center-content">
    <form:form action="${pageContext.request.contextPath}/students/edit/${student.id}" method="post" modelAttribute="student">
        <form:hidden path="id"/>

        <label>Name:</label><br/>
        <form:input path="name" cssErrorClass="input-error"/><br/>
        <form:errors path="name" cssClass="error-message"/><br/><br/>

        <label>Email:</label><br/>
        <form:input path="email" cssErrorClass="input-error"/><br/>
        <form:errors path="email" cssClass="error-message"/><br/><br/>

        <label>Courses:</label><br/>
        <c:forEach var="course" items="${courses}">
            <form:checkbox path="courseIds" value="${course.id}"/>
            ${course.name}<br/>
        </c:forEach>
        
        <br/>
        <div class="button-group">
            <button type="submit">Update</button>
        </div>
        <!-- <a href="${pageContext.request.contextPath}/students/list">
            <button>Home</button>
        </a> -->
        <button type="button" onclick="window.location.href='/students'">Cancel</button>
    </form:form>
    </div>
</div>
</body>
</html>
