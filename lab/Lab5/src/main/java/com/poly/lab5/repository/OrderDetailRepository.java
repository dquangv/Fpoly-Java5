package com.poly.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.OrderDetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = (SELECT o.id FROM OrderDetail o GROUP BY o.order.id ORDER BY SUM(o.price * o.quantity) DESC LIMIT 1)")
    List<OrderDetail> findHighestValueOrder();

    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = (SELECT o.id FROM OrderDetail o GROUP BY o.order.id ORDER BY SUM(o.price * o.quantity) asc LIMIT 1)")
    List<OrderDetail> findLowestValueOrder();
}
