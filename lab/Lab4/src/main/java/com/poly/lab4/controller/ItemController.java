package com.poly.lab4.controller;

import com.poly.lab4.service.ShoppingCartService;
import com.poly.lab4.utils.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @RequestMapping("/item/index")
    public String list(Model model) {
        model.addAttribute("items", DB.items.values());

        return "item/index";
    }

}
