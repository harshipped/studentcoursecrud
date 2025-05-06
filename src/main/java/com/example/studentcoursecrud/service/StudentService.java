package com.example.studentcoursecrud.service;

import com.example.studentcoursecrud.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);

    List<Student> getAllStudentsWithCourses();
}
