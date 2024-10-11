package com.poly.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Account;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String>{
    @Query("SELECT od.order.account FROM OrderDetail od GROUP BY od.order.account.username ORDER BY SUM(od.price * od.quantity) DESC LIMIT 1")
    Account findCustomerWithHighestTotalSpent();


}
