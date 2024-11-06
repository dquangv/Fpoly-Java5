package com.example.practise.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;  // Import annotation validation
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{NotBlank.book.title}")  // Kiểm tra không để trống
    @Size(max = 100, message = "Title cannot exceed 100 characters")  // Độ dài tối đa
    @Column(nullable = false, length = 100)
    private String title;

    @NotBlank(message = "{NotBlank.book.author}")  // Kiểm tra không để trống
    @Size(max = 50, message = "Author cannot exceed 50 characters")  // Độ dài tối đa
    @Column(nullable = false, length = 50)
    private String author;

    @NotNull(message = "{NotNull.book.price}")  // Kiểm tra không null
    @Min(value = 0, message = "Price must be greater than or equal to 0")  // Giá tối thiểu
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "{NotNull.book.timePublished}")  // Kiểm tra không null
    @Column(nullable = false)
    private LocalDateTime timePublished;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    public String getFormattedTimePublished() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.timePublished.format(formatter);
    }
}
