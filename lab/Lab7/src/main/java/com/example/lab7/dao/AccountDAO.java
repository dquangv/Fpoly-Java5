package com.example.lab7.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab7.model.Account;




public interface AccountDAO extends JpaRepository<Account, String>{

	Account findByUsername(String username);
}
