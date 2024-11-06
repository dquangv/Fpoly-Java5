package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
