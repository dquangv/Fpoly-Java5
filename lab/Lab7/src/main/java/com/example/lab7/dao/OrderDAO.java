package com.example.lab7.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab7.model.Order;




public interface OrderDAO extends JpaRepository<Order, Long>{
}
