package com.Java20CybersoftStudentController.restfulapi.controller;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import com.Java20CybersoftStudentController.restfulapi.model.StudentModel;
@RestController
@RequestMapping("/student")
public class StudentController {
    private List<StudentModel> allStudents = new ArrayList<>();
    @GetMapping("")
    public List<StudentModel> getAllStudents() {
        return allStudents;
    }

    @GetMapping("/add")
    public List<StudentModel> addRequestParam(
            @RequestParam("name") String name, @RequestParam("age") int age
    ) {
        StudentModel student = new StudentModel();
        student.setName(name);
        student.setAge(age);
        allStudents.add(student);
        return allStudents;
    }

    @GetMapping("/add/{name}/{age}")
    public List<StudentModel> addPathVariable(
            @PathVariable("name") String name, @PathVariable("age") int age
    ) {
        StudentModel student = new StudentModel();
        student.setName(name);
        student.setAge(age);
        allStudents.add(student);
        return allStudents;
    }

    @PostMapping(value = "add", consumes = "application/json")
    public List<StudentModel> add(
            @RequestBody StudentModel student
    ) {
        allStudents.add(student);
        return allStudents;
    }
}
