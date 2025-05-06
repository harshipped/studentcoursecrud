package com.example.studentcoursecrud.service;

import com.example.studentcoursecrud.model.Student;
import com.example.studentcoursecrud.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        // Fetch students with their associated courses using the custom query
        return studentRepo.findAllWithCourses();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id);
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setCourses(updatedStudent.getCourses());
        return studentRepo.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Break the relationship with all courses
        student.getCourses().clear(); // removes all course links

        studentRepo.delete(student); // then delete the student
    }

    @Override
    public List<Student> getAllStudentsWithCourses() {
        return studentRepo.findAllWithCourses();
    }

}
