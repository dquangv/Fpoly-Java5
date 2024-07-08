package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
	@RequestMapping("/testDemo")
	public String test(Model model) {
		model.addAttribute("message", "Hello Thuan huhu");
		return "test";
	}
	
}