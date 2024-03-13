package com.StudentManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int Id;
    private String name;
    private String email;
    private String course;
    private String address;
    private Long mobile;
}
