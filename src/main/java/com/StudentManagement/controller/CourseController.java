package com.StudentManagement.controller;

import com.StudentManagement.Exception.NoSuchCourseFoundException;
import com.StudentManagement.entity.Course;
import com.StudentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        String message = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        String message = courseService.updateCourse(course);
        return ResponseEntity.ok().body("Updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        String message = courseService.deleteCourse(id);
        return ResponseEntity.ok().body("Has been Deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        Course course = courseService.getCourse(id);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return ResponseEntity.ok().body(courses);
    }

    @ExceptionHandler(NoSuchCourseFoundException.class)
    public ResponseEntity<String> handleNoSuchCourseFoundException(NoSuchCourseFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

