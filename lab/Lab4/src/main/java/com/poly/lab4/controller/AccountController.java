package com.poly.lab4.controller;

import com.poly.lab4.model.Account;
import com.poly.lab4.service.AccountService;
import com.poly.lab4.service.CookieService;
import com.poly.lab4.service.ParamService;
import com.poly.lab4.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login1() {
        return "/account/login";
    }

    @PostMapping("/login")
    public String login2(Model model) {
        String un = paramService.getString("username", "");
        String pwd = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        try {
            Account account = accountService.findByID(un);
            if (!pwd.equals(account.getPassword())) {
                sessionService.set("username", un);
                model.addAttribute("message", "Invalid password");
            } else {

                if (rm) {
                    cookieService.add("user", un, 10);
                } else {
                    cookieService.remove("user");
                }

                model.addAttribute("message", "Login successful");
            }
        } catch (Exception e) {
            model.addAttribute("message", "Invalid Username");
        }

        return "/account/login";
    }
}
