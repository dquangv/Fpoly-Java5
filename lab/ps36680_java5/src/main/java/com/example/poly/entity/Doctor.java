package com.example.poly.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;  // Import annotation validation
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{NotBlank.doctor.firstname}")  // Kiểm tra không để trống
    @Size(max = 100, message = "Title cannot exceed 100 characters")  // Độ dài tối đa
    @Column(nullable = false, length = 100)
    private String lastName;

    @NotBlank(message = "{NotBlank.doctor.lastname}")  // Kiểm tra không để trống
    @Size(max = 50, message = "Author cannot exceed 50 characters")  // Độ dài tối đa
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotNull(message = "{NotNull.doctor.salary}")  // Kiểm tra không null
    @Min(value = 0, message = "Price must be greater than or equal to 0")  // Giá tối thiểu
    @Column(nullable = false)
    private Double salary;

    @NotNull(message = "{NotNull.doctor.hireDate}")  // Kiểm tra không null
    @Column(nullable = false)
    private LocalDateTime hireDate;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Genre genre;

    public String getFormattedHireDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.hireDate.format(formatter);
    }
}
