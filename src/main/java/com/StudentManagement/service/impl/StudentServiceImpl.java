package com.StudentManagement.service.impl;

import com.StudentManagement.entity.Student;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.service.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }



    @Override
    public Student getStudent(String studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(Integer.parseInt(studentId));
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new EntityNotFoundException("Student not found with ID: " + studentId);
        }
    }


    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }
    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Your data is saved successfully";
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Updated Successfully";
    }

    @Override
    public String deleteStudent(String studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(Integer.parseInt(studentId));
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return "Deleted Successfully";
        } else {
            return "Student not found with ID: " + studentId;
        }

    }

}
