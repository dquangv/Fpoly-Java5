package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;
import com.example.demo.entity.Report;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE "
		     + " (cast(p.id as string) = :keyword OR "
		     + " p.name LIKE %:keyword% OR "
		     + " cast(p.price as string) = %:keyword% OR "
		     + " cast(p.createDate as string) LIKE %:keyword% OR "
		     + " cast(p.available as string) = %:keyword% OR "
		     + " p.category.name LIKE %:keyword%)")
		Page<Product> searchProducts(String keyword, Pageable pageable);

	@Query("SELECT new Report(o.category, sum(o.price), count(o)) "
			+ " FROM Product o "
			+ " GROUP BY o.category"
			+ " ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByCategory();
}