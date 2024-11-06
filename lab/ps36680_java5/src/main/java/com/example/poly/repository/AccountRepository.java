package com.example.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poly.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUserName(String username);
}
