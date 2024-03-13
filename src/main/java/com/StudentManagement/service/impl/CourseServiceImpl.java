package com.StudentManagement.service.impl;

import com.StudentManagement.Exception.NoSuchCourseFoundException;
import com.StudentManagement.entity.Course;
import com.StudentManagement.repository.CourseRepository;
import com.StudentManagement.service.CourseService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String createCourse(Course course) {
        Course saved = courseRepository.save(course);
        return "Course added Successfully";
    }

    @Override
    public String updateCourse(Course course) {
        Course update = courseRepository.save(course);
        return "Updated Successfully";
    }

    @Override
    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return "Course with ID " + courseId + " has been deleted";
    }


    @Override
    public Course getCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.orElseThrow(() -> new NoSuchCourseFoundException("Course Not Found"+ courseId)) ;
    }

    @Override
    public List<Course> getAllCourse() {

        return courseRepository.findAll();
    }
}
