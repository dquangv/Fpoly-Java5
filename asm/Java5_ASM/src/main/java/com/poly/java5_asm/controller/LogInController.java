package com.poly.java5_asm.controller;

import com.poly.java5_asm.model.Account;
import com.poly.java5_asm.model.User;
import com.poly.java5_asm.repository.AccountRepository;
import com.poly.java5_asm.repository.UserRepository;
import com.poly.java5_asm.service.EmailService;
import com.poly.java5_asm.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            Account acc = accountRepository.findAccountByEmail(email);
            User user = userRepository.findByEmail(email);

            if (acc == null || !acc.getPassword().equals(password)) {
                model.addAttribute("message", "Thông tin tài khoản chưa chính xác");
            } else {
                sessionService.set("user", user);
                sessionService.set("account", acc);
                model.addAttribute("user", user);

                return "redirect:/index";
            }
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "user/login";
    }

    @GetMapping("/logout")
    public String logout() {
        User user = (User) sessionService.get("user");

        if (user != null) {
            sessionService.set("user", null);
            sessionService.set("account", null);
        }

        return "redirect:/index";
    }
}
