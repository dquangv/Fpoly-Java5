package com.poly.lab2.controller;

import com.poly.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController2 {

    @RequestMapping("/product/form2")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("product1", p);
        return "bai4/form";
    }

    @RequestMapping("/product/save2")
    public String save(@ModelAttribute Product product, Model model) {
        model.addAttribute("message", "Success");
        return "forward:/product/form2";
    }

    @ModelAttribute("products")
    public List<Product> getItems() {
        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
    }
}
