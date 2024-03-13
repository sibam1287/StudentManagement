package com.StudentManagement.controller;

import com.StudentManagement.entity.Student;
import com.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Read specific Student detail from Db
    @GetMapping("/{studentId}")
    public Student getStudentDetails(@PathVariable String studentId) {
        return studentService.getStudent(studentId);
    }

    // Read All Student detail from Db
    @GetMapping
    public List<Student> getAllStudentDetails() {
        return studentService.getAllStudents();
    }

    // Create Student
  @PostMapping("/create")
    public String createStudentDetails(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Student data created successfully";
    }

    // Update Student
    @PutMapping("/{studentId}")
    public String updateStudentDetails(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Student data updated successfully";
    }

    // Delete Student
    @DeleteMapping("/{studentId}")
    public String deleteStudentDetails(@PathVariable String studentId) {
        studentService.deleteStudent(studentId);
        return "Student details deleted successfully";
    }
}
