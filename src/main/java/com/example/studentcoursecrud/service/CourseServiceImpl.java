package com.example.studentcoursecrud.service;

import com.example.studentcoursecrud.model.Course;
import com.example.studentcoursecrud.model.Student;
import com.example.studentcoursecrud.repository.CourseRepository;
// import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Remove the course from all students
        List<Student> students = course.getStudents();
        for (Student student : students) {
            student.getCourses().remove(course);
        }

        course.getStudents().clear(); // clear all associations

        courseRepository.delete(course);
    }

}
