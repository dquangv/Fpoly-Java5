package com.poly.lab5.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.lab5.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	/*
	 * @Query("SELECT new Report(o.category, sum(o.price), count(o)) " +
	 * " FROM Product o " + " GROUP BY o.category" + " ORDER BY sum(o.price) DESC")
	 * List<Report> getInventoryByCategory();
	 */

}
