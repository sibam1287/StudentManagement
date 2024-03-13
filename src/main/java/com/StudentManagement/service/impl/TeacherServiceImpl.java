package com.StudentManagement.service.impl;

import com.StudentManagement.entity.Teacher;
import com.StudentManagement.repository.TeacherRepository;
import com.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }

    @Override
    public String updateTeacher(Teacher teacher) {
        Teacher saved = teacherRepository.save(teacher);
        return "Updated Successfully";
    }

    @Override
    public String deleteTeacher(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);

        if (optionalTeacher.isPresent()) {
            teacherRepository.delete(optionalTeacher.get());
            return "Deleted Successfully";
        } else {
            return "Teacher not found with ID: " + teacherId;
        }
    }




    public Teacher getTeacherById(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        return optionalTeacher.orElseThrow(() -> new NoSuchElementException("Teacher not found with ID: " + teacherId));
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
}
