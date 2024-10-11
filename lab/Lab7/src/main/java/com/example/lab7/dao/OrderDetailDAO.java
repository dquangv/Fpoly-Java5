package com.example.lab7.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab7.model.OrderDetail;




public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
}