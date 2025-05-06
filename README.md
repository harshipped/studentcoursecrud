# Student-Course CRUD Management System

A full-stack Spring Boot web application to manage Students and Courses using CRUD operations. Built using Spring Boot, JSP, JPA, Hibernate Validator.

---

## Features

- Create, Read, Update, Delete (CRUD) operations for:
  - Students
  - Courses
- Many-to-Many relationships
- JSP views with CSS styling
- Form validation using Hibernate Validator
- Exception handling for invalid operations
- Embedded H2 and MySQL database support

---

## Technologies Used

- **Spring Boot 3.4.5**
- **Spring Data JPA**
- **Hibernate Validator**
- **JSP + JSTL**
- **Tomcat Jasper for JSP rendering**
- **MySQL Database**
- **Maven**

---

## How to Run

1. Clone the repository
   git clone https://github.com/shipped-by-harsh/studentcoursecrud.git

   cd studentcoursecrud

2. Update DB config in `application.properties` (use H2 for testing or MySQL)

3. Build and run the project

   mvn spring-boot:run

4. Visit the app in your browser

   http://localhost:8080/students/list

---

## Navigation

- `/students/list` - View all students
- `/students/add` - Add new student
- `/courses/list` - View all courses
- `/courses/new` - Add new course

---

## Requirements

- Java 17
- Maven 3.8+
- MySQL or use embedded H2
