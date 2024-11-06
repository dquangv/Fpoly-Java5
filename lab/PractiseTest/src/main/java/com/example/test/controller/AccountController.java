package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test.entity.Account;
import com.example.test.repository.AccountRepository;
import com.example.test.service.SessionService;

@Controller
public class AccountController {
	@Autowired
	SessionService sessionService;
	@Autowired
	AccountRepository dao;
	
	@GetMapping("/account/login")
	public String view() {
		return "account/login";
	}
	
	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			Account user = dao.findByUserName(username);
			if (user==null || !user.getPassword().equals(password)) {
				model.addAttribute("message", "Invalid username or password!");
			} else {
				sessionService.set("user", user);
				System.out.println(sessionService.get("user"));
				String uri = (String) sessionService.get("security-uri");
				if (uri != null) {
					return "redirect:" + uri;
				} else {					
					model.addAttribute("message", "Login success");
					return "redirect:/book/index";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "account/login";
	}
	
	@GetMapping("/account/logout")
	public String accountLogout() {
		Account accountLogin = (Account)sessionService.get("user");
		if(accountLogin != null)
			sessionService.set("user", null);
		return "/account/login";
	}
}
