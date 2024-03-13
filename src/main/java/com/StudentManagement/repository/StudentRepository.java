package com.StudentManagement.repository;




import com.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

/*    // You can define custom queries here if needed
    // For example, find students by course
    List<Student> findByCourse(String course);

    // Or find students by email
    Student findByEmail(String email);*/
}
