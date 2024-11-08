package com.poly.java5_asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/home/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "user/verify-otp";
    }
}
