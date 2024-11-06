package com.example.practise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practise.entity.Account;
import com.example.practise.entity.Book;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUserName(String username);
}
