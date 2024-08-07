package com.poly.lab4.service;

import com.poly.lab4.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    public static List<Account> list = new ArrayList<>();

    static {
        list.add(new Account("poly", "123", true));
    }

    @Override
    public Account findByID(String username) {
        for (Account account : list) {
            if(username.equals(account.getUsername())) {
                return account;
            }
        }

        return null;
    }

}
