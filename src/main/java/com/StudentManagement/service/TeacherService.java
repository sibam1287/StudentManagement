package com.StudentManagement.service;

import com.StudentManagement.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TeacherService {

    public Teacher createTeacher(Teacher teacher);
    public String updateTeacher(Teacher teacher);


    public String deleteTeacher(Long teacherId);

    public Teacher getTeacherById(Long id);
    public List<Teacher> getAllTeacher();

}
