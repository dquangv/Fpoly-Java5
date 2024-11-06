package com.example.practise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practise.entity.Book;
import com.example.practise.entity.Genre;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByTitleContaining(String title);
    List<Book> findByGenre(Genre genre);
    List<Book> findByTitleContainingAndGenre(String title, Genre genre);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Book> findByTitleContainingAndGenreAndPriceBetween(String title, Genre genre, Double minPrice, Double maxPrice);

    List<Book> findByGenreAndPriceBetween(Genre genre, Double minPrice, Double maxPrice);
    List<Book> findByTitleContainingOrAuthorContaining(String title, String author);
    List<Book> findByTitleContainingOrAuthorContainingAndGenreAndPriceBetween(String title, String author, Genre genre, Double minPrice, Double maxPrice);

}
