package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUserName(String username);
}
