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

import java.util.Random;

@Controller
public class SignUpController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/signup")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

    @PostMapping("/signup")
    public String register(User user, Model model, @RequestParam("password") String password,
                           @RequestParam("email") String email) {

        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email đã được sử dụng!");
            return "user/registration";
        }


        Account account = new Account(password, false, user);

        sessionService.set("newAcc", account);
        sessionService.set("newUser", user);

        String otp = generateOTP();

        // send otp to email
        emailService.sendOTP(user.getEmail(), otp);

        sessionService.set("otp", otp);
        sessionService.set("createTime", System.currentTimeMillis());

        return "user/verify-otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOTP(@RequestParam("otp") String otp, Model model) {
        String savedOTP = (String) sessionService.get("otp");
        long createTime = (long) sessionService.get("createTime");

        // Check OTP
        if (otp.equals(savedOTP) && (System.currentTimeMillis() - createTime) <= 60000) {
            // Save user and account into database
            userRepository.save((User) sessionService.get("newUser"));
            accountRepository.save((Account) sessionService.get("newAcc"));

            // Clear session data
            sessionService.set("otp", null);
            sessionService.set("createTime", null);
            sessionService.set("newAcc", null);
            sessionService.set("newUser", null);

            return "redirect:/login";
        } else {
            System.out.println("error OTP " + otp);
            model.addAttribute("message", "Mã OTP không hợp lệ hoặc đã hết hạn!");
            return "user/verify-otp";
        }
    }


    @GetMapping("/resend-otp")
    public String resendOTP(Model model) {
        // get email from session
        User user = (User) sessionService.get("newUser");
        String email = user.getEmail();

        if (email != null) {
            // generate a new otp
            String otp = generateOTP();

            //resend otp to email
            emailService.sendOTP(email, otp);

            // save otp and set time for it
            sessionService.set("otp", otp);
            sessionService.set("createTime", System.currentTimeMillis());

            model.addAttribute("message", "Mã OTP đã được gửi lại!");
        } else {
            model.addAttribute("message", "Không thể gửi lại OTP. Vui lòng thử lại!");
        }

        return "user/verify-otp";
    }

    //generate otp containing 6 random numbers
    private String generateOTP() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}