package com.StudentManagement.service;

import com.StudentManagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public String createStudent(Student student);
    public String updateStudent(Student student);
    public String deleteStudent(String studentId);
    public Student getStudent(String studentId);
    public List<Student> getAllStudents();

}
