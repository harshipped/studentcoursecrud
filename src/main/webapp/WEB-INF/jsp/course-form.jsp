<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Course Form</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <div class="form-container">
<h2>${course.id == null ? 'Create Course' : 'Edit Course'}</h2>
<div class="center-content">
<form:form action="${pageContext.request.contextPath}/courses/save" method="post" modelAttribute="course">
    <form:hidden path="id" />
    <label>Course Name:</label><br/>
    <form:input path="name" required="true" cssErrorClass="error"/>
    <form:errors path="name" cssClass="error-message"/><br/><br/>

    <button type="submit">${course.id == null ? 'Create' : 'Update'}</button>
</form:form>
</div>

<a href="${pageContext.request.contextPath}/courses">
    <button>Back to Course List</button></a>

<a href="${pageContext.request.contextPath}/students/list">
    <button>Home</button>
</a>
    </div>


</body>
</html>
