package com.poly.lab4.controller;

import com.poly.lab4.model.Account;
import com.poly.lab4.service.AccountService;
import com.poly.lab4.service.CookieService;
import com.poly.lab4.service.ParamService;
import com.poly.lab4.service.SessionService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/account")
@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String login1(Model model) {
        String savedUsername = cookieService.getValue("username");
        String savedPassword = cookieService.getValue("password");
        
        model.addAttribute("savedUsername", savedUsername);
        model.addAttribute("savedPassword", savedPassword);
        
        return "/account/login"; 
    }


    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login2(Model model) {
        String un = paramService.getString("username", "");
        String pwd = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);
        Map<String, String> response = new HashMap<>();

        try {
            Account account = accountService.findByID(un);
            if (!pwd.equals(account.getPassword())) {
                sessionService.set("username", un);
                response.put("message", "Invalid password");
            } else {
                if (rm) {
                    cookieService.add("user", un, 10);
                } else {
                    cookieService.remove("user");
                }
                response.put("message", "Login successful");
            }
        } catch (Exception e) {
            response.put("message", "Invalid Username");
        }

        return response;
    }
}
