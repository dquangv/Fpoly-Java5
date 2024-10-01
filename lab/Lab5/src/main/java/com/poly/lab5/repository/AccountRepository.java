package com.poly.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
