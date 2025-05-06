<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <div class="form-container">
        <h2>Add Student</h2>
        <form:form action="${pageContext.request.contextPath}/students/add" method="post" modelAttribute="student">
            <label for="name">Name</label><br/>
            <form:input path="name" id="name" cssErrorClass="input-error"/><br/>
            <form:errors path="name" cssClass="error-message"/><br/>

            <label for="email">Email</label><br/>
            <form:input path="email" id="email" cssErrorClass="input-error"/><br/>
            <form:errors path="email" cssClass="error-message"/><br/>

            <label>Courses</label><br/>
            <c:forEach items="${courses}" var="course">
                <input type="checkbox" name="courseIds" value="${course.id}"/> ${course.name}<br/>
            </c:forEach>

            <br/>
            <button type="submit">Add Student</button>
            <!-- <a href="${pageContext.request.contextPath}/students/list">
                <button>Home</button>
            </a> -->
            <button type="button" onclick="window.location.href='/students'">Cancel</button>
        </form:form>
    </div>
</body>
</html>
