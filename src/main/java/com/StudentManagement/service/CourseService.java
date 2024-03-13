package com.StudentManagement.service;

import com.StudentManagement.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {
    public String createCourse(Course course);
    public String updateCourse(Course course);

    public String deleteCourse(Long courseId);

    public Course getCourse(Long courseId);

    public List<Course>getAllCourse();
}
