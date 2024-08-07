package com.poly.lab3.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank(message = "Vui lòng điền tên")
    String name;
    @NotBlank(message = "Vui lòng điền email")
    @Email(message = "Vui lòng nhập đúng định dạng email")
    String email;
    @Min(0)
    @Max(10)
    @NotNull
    Double marks;
    @NotNull
    Boolean gender;
    @NotBlank
    String faculty;
    @NotEmpty
    List<String> hobbies;
}
