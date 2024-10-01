package com.poly.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
