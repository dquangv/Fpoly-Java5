package com.poly.java5_asm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountid")
    private int accountId;
    private String password;
    private boolean role;
    @OneToOne @JoinColumn(name = "email")
    private User user;

    public Account(String password, boolean role, User user) {
        super();
        this.password = password;
        this.role = role;
        this.user = user;
    }
}
