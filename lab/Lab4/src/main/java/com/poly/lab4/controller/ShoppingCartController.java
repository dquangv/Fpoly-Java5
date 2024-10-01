package com.poly.lab4.controller;

import com.poly.lab4.model.Laptop;
import com.poly.lab4.service.ShoppingCartService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", shoppingCartService.getItems());
        model.addAttribute("quality", shoppingCartService.getCount());
        model.addAttribute("sum", shoppingCartService.getAmount());
        return "cart/cart";
    }

    @RequestMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        shoppingCartService.add(id);
        return "redirect:/cart/view";
    }

    @PostMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        shoppingCartService.remove(id);
        System.out.print(shoppingCartService.getItems());
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
        shoppingCartService.update(id, qty);
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/clear")
    public String clear() {
        shoppingCartService.clear();
        return "redirect:/cart/view";
    }
}
