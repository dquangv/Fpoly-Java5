package com.poly.java5_asm.service;


import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    static JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendOTP(String email, String otp) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setFrom("dhuyclone2001@gmail.com");
            helper.setTo(email);
            helper.setSubject("Mã OTP xác nhận đăng ký");
            helper.setText("Mã OTP của bạn là: " + otp, true); // true for HTML content

            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
