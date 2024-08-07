package com.poly.lab4.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @NotEmpty(message = "Username is empty")
    String username;
    @NotEmpty(message = "Password is empty")
    String password;
    boolean admin;
}
