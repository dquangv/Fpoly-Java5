package com.poly.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}