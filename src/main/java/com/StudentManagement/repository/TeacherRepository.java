package com.StudentManagement.repository;

import com.StudentManagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long > {

}
