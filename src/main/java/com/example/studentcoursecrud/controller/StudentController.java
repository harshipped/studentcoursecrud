package com.example.studentcoursecrud.controller;

import com.example.studentcoursecrud.model.Course;
import com.example.studentcoursecrud.model.Student;
import com.example.studentcoursecrud.service.CourseService;
import com.example.studentcoursecrud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Form to add a new student
    @GetMapping({ "/add", "/new" })
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "add-student"; // JSP page name
    }

    // Handling form submission
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") @Valid Student student,
            BindingResult result,
            @RequestParam(required = false) List<Long> courseIds, // Marked as optional
            Model model) {

        // Checks if courseIds is null or empty and handle the case
        if (courseIds != null && !courseIds.isEmpty()) {
            List<Course> selectedCourses = courseIds.stream()
                    .map(courseService::getCourseById)
                    .collect(Collectors.toList());
            student.setCourses(selectedCourses);
        } else {
            student.setCourses(Collections.emptyList()); // If no courses selected, set an empty list
        }

        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "add-student"; // Re-display form with validation errors
        }

        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    // To show the list of students
    @GetMapping({ "", "/", "/home", "/home/", "/list" })
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "list-students";
    }

    // GET: Show the edit form with existing student data
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        List<Course> courses = courseService.getAllCourses();

        // Set courseIds for form binding
        List<Long> courseIds = student.getCourses()
                .stream()
                .map(Course::getId)
                .collect(Collectors.toList());
        student.setCourseIds(courseIds);

        model.addAttribute("student", student);
        model.addAttribute("courses", courses);

        return "edit-student";
    }

    // POST: Save updated student data
    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id,
            @ModelAttribute("student") @Valid Student student,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "edit-student";
        }

        student.setId(id);
        List<Course> selectedCourses = student.getCourseIds()
                .stream()
                .map(courseService::getCourseById)
                .collect(Collectors.toList());
        student.setCourses(selectedCourses);

        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    // Deleteing student records and redirecting to the student list
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

    @GetMapping("/joined")
    public String listStudentsWithCourses(Model model) {
        List<Student> students = studentService.getAllStudentsWithCourses(); // Use the joined query
        model.addAttribute("students", students);
        return "joined-students";
    }

}
