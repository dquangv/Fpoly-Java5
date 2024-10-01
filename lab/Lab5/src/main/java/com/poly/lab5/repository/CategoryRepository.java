package com.poly.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
}
