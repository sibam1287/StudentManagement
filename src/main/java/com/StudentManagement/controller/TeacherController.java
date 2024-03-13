package com.StudentManagement.controller;

import com.StudentManagement.entity.Teacher;
import com.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeacher();
    }
    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable Long teacherId) {
        Teacher teacherById = teacherService.getTeacherById(teacherId);
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping("/create")
    public String createTeacher(@RequestBody Teacher teacher) {
        Teacher saved = teacherService.createTeacher(teacher);
        return "Teacher data updated successfully";
    }

    @PutMapping
    public String updateTeacher(@RequestBody Teacher teacher) {
        String s = teacherService.updateTeacher(teacher);
        return "Teacher data updated successfully";
    }

    @DeleteMapping("/{teacherId}")
    public String deleteTeacher(@PathVariable Long teacherId) {
        String deleted = teacherService.deleteTeacher(teacherId);
        return "Teacher details deleted successfully";
    }



    }

