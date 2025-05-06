package com.example.studentcoursecrud.repository;

import com.example.studentcoursecrud.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
