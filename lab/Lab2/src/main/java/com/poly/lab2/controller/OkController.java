package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {
    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }
    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("message", "Method 1");
        return "ok";
    }
    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("message", "Method 2");
        return "ok";
    }
    @PostMapping("/ctrl/ok/{x}")
    public String m3(Model model, @PathVariable("x") String x) {
        model.addAttribute("message", "Method 3");
        return "ok";
    }
}
