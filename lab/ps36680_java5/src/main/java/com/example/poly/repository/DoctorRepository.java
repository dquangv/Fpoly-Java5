package com.example.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poly.entity.Doctor;
import com.example.poly.entity.Genre;


public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	/*
	 * List<Doctor> findByTitleContaining(String title); List<Doctor>
	 * findByGenre(Genre genre); List<Doctor> findByTitleContainingAndGenre(String
	 * title, Genre genre);
	 */
    List<Doctor> findBySalaryBetween(Double minPrice, Double maxPrice);
//    List<Doctor> findByTitleContainingAndGenreAndPriceBetween(String title, Genre genre, Double minPrice, Double maxPrice);

//    List<Doctor> findByGenreAndPriceBetween(Genre genre, Double minPrice, Double maxPrice);
//    List<Doctor> findByTitleContainingOrAuthorContaining(String title, String author);
//    List<Doctor> findByTitleContainingOrAuthorContainingAndGenreAndPriceBetween(String title, String author, Genre genre, Double minPrice, Double maxPrice);

    List<Doctor> findByLastNameContainingOrFirstNameContaining(String lastName, String firstName);
    List<Doctor> findByLastNameContainingOrFirstNameContainingAndSalaryBetween(String lastName, String firstName, Double minPrice, Double maxPrice);
}
