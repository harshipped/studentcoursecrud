package com.example.studentcoursecrud.repository;

import com.example.studentcoursecrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query to fetch students along with their courses
    @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :id")
    Student findByIdWithCourses(@Param("id") Long id);

    @Query("SELECT s FROM Student s JOIN FETCH s.courses")
    List<Student> findAllWithCourses();
}
