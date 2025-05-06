package com.example.studentcoursecrud.service;

import com.example.studentcoursecrud.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

}
