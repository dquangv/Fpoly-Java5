package com.poly.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank(message = "{NotBlank.student.name}")
    String name;
    @NotBlank(message = "{NotBlank.student.email}")
    @Email(message = "{Email.student.email}")
    String email;
    @Min(0)
    @Max(10)
    @NotNull(message = "{NotNull.student.marks}")
    Double marks;
    @NotNull(message = "{NotNull.student.gender}")
    Boolean gender;
    String faculty;
    List<String> hobbies;
}
