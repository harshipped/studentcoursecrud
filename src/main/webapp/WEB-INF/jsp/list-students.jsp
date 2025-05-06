<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Students</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>

<h1>List of Students</h1>
<!-- Button to add a new student -->
<a href="${pageContext.request.contextPath}/students/add">
    <button>Add New Student</button>
</a>
<a href="${pageContext.request.contextPath}/courses">
    <button>List of Courses</button>
</a>
<a href="${pageContext.request.contextPath}/courses/new">
    <button>Add new course</button>
</a>

<a href="${pageContext.request.contextPath}/students/joined">
    <button>View Students with Courses</button>
</a>


<!-- Table to display students and their courses -->
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Courses</th>
            <th class="actions">Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- Single loop that displays all details -->
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>
                    <c:forEach var="course" items="${student.courses}">
                        ${course.name}<br>
                    </c:forEach>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/students/edit/${student.id}"><button>Update</button></a> |
                    <a href="${pageContext.request.contextPath}/students/delete/${student.id}"
                       onclick="return confirm('Are you sure you want to delete this student?');"><button class="delete">Delete</button></a>
                </td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
