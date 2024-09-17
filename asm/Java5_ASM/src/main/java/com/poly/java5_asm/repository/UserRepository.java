package com.poly.java5_asm.repository;

import com.poly.java5_asm.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.email like ?1")
    Page<User> findByEmailLike(String email, Pageable pageable);

    @Query("select u from User u where u.email = ?1")
    User findByEmail(String mail);

    boolean existsByEmail(String email);
}
