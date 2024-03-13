package com.StudentManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {

    private String id;
    private String name;

    private String email;

    private String subject;

    private String address;

    private Long mobile;
}

