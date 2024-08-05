package com.poly.lab2.controller;

import com.poly.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form() {
        return "bai3/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product, Model model) {
        model.addAttribute("p", product);
        return "bai3/form";
    }
}
