package com.example.studentcoursecrud;

import com.example.studentcoursecrud.model.Course;
import com.example.studentcoursecrud.model.Student;
import com.example.studentcoursecrud.repository.CourseRepository;
import com.example.studentcoursecrud.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// @Component
public class DataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public DataInitializer(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... args) {
        // 💡 Only run if no courses or students exist
        if (courseRepo.count() > 0 || studentRepo.count() > 0) {
            System.out.println("Database already initialized. Skipping data insert.");
            return;
        }

        // Create Courses
        List<Course> courses = Arrays.asList(
                new Course("Mathematics"),
                new Course("Physics"),
                new Course("Chemistry"),
                new Course("Biology"),
                new Course("History"),
                new Course("Geography"),
                new Course("English"),
                new Course("Computer Science"),
                new Course("Economics"),
                new Course("Philosophy"));
        courseRepo.saveAll(courses);

        // Create Students
        List<Student> students = Arrays.asList(
                new Student("Alice", "alice@example.com"),
                new Student("Bob", "bob@example.com"),
                new Student("Charlie", "charlie@example.com"),
                new Student("Diana", "diana@example.com"),
                new Student("Edward", "edward@example.com"),
                new Student("Fiona", "fiona@example.com"),
                new Student("George", "george@example.com"),
                new Student("Hannah", "hannah@example.com"),
                new Student("Ian", "ian@example.com"),
                new Student("Jenny", "jenny@example.com"));

        // Assign students to random courses
        students.get(0).setCourses(Arrays.asList(courses.get(0), courses.get(1)));
        students.get(1).setCourses(Arrays.asList(courses.get(2), courses.get(3)));
        students.get(2).setCourses(Arrays.asList(courses.get(4), courses.get(5)));
        students.get(3).setCourses(Arrays.asList(courses.get(6), courses.get(7)));
        students.get(4).setCourses(Arrays.asList(courses.get(8)));
        students.get(5).setCourses(Arrays.asList(courses.get(9), courses.get(0)));
        students.get(6).setCourses(Arrays.asList(courses.get(1), courses.get(2)));
        students.get(7).setCourses(Arrays.asList(courses.get(3), courses.get(4)));
        students.get(8).setCourses(Arrays.asList(courses.get(5), courses.get(6)));
        students.get(9).setCourses(Arrays.asList(courses.get(7), courses.get(8), courses.get(9)));

        studentRepo.saveAll(students);

        System.out.println("Sample data inserted.");
    }
}
