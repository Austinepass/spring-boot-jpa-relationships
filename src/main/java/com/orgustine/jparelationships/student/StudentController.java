package com.orgustine.jparelationships.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
