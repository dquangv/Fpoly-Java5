package com.example.lab7.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab7.model.Category;





public interface CategoryDAO extends JpaRepository<Category, String>{
}
