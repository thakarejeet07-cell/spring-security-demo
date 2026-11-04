package com.jeet.spring_security_demo.controller;

import com.jeet.spring_security_demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Navin", 60),
            new Student(2, "Kiran", 65)
    ));

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}