package com.poly.java5_asm.repository;

import com.poly.java5_asm.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select a from Account a where a.user.email=:email")
    Account findAccountByEmail(@Param("email") String email);
}
