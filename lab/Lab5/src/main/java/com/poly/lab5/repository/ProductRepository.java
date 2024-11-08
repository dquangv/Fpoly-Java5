package com.poly.lab5.repository;

import java.util.Date;
import java.util.List;

import com.poly.lab5.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.lab5.entity.Product;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	/*
	 * @Query("SELECT new Report(o.category, sum(o.price), count(o)) " +
	 * " FROM Product o " + " GROUP BY o.category" + " ORDER BY sum(o.price) DESC")
	 * List<Report> getInventoryByCategory();
	 */

	List<Product> findByPriceBetween(Double min, Double max);

	List<Product> findByNameContaining(String name);

	@Query("select new Report(p.name, sum(o.price), count(o)) from Product p join p.orderDetais o group by p.name")
	List<Report> getReport();

	@Query(value = "SELECT p.* FROM Products p "
			+ "JOIN OrderDetails od ON p.id = od.Productid "
			+ "JOIN Orders o ON o.id = od.Orderid "
			+ "WHERE o.CreateDate BETWEEN :beginDate AND :endDate "
			+ "GROUP BY p.id "
			+ "ORDER BY SUM(od.quantity) DESC "
			+ "LIMIT :n", nativeQuery = true)
	List<Product> findTopNBestSellingProducts(
			@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate,
			@Param("n") int n);
}
