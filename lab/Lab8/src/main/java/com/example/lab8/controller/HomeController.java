package com.example.lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index() {
		return "layout/index";
	}

	@RequestMapping("/home/about")
	public String about() {
		return "layout/about";
	}
	@RequestMapping("/home/contact")
	public String contact() {
		return "layout/contact";
	}
	@RequestMapping("/home/hoiDap")
	public String hoiDap() {
		return "layout/hoiDap";
	}

}
