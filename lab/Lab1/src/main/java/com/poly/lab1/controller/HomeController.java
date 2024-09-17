package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("message", "Welcome to MVC - Vũ Đăng Quang");
		
		return "index";
	}
}
