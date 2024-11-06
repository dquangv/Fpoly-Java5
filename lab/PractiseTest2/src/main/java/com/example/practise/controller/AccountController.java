package com.example.practise.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.practise.entity.Account;
import com.example.practise.repository.AccountRepository;
import com.example.practise.service.SessionService;

@Controller
public class AccountController {
	Logger logger = LogManager.getLogger(AccountController.class);
	
	@Autowired
	AccountRepository dao;
	
	@Autowired
	SessionService session;
	
//	@GetMapping("/account/login")
//	public String login() {
//		return "account/login";
//	}
	
	@GetMapping("/account/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
	    if (error != null) {
	        model.addAttribute("message", error); // Hiển thị thông báo lỗi nếu có
	    }
	    return "account/login";
	}

	
	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		logger.info("User Login: " + username);
		try {
			Account user = dao.findByUserName(username);
			if (user==null || !user.getPassword().equals(password)) {
				logger.warn("Login Fail: " + username);
				model.addAttribute("message", "Invalid username or password!");
			} else {
				session.set("user", user);
				String uri = (String) session.get("security-uri");
				logger.info("Login success: " + username);
				if (uri != null) {
					return "redirect:" + uri;
				} else {					
					return "redirect:/books";
				}
				
			}
		} catch (Exception e) {
			logger.error("Error Login: " + username);
			model.addAttribute("message", "Invalid username");
		}
		return "account/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
	    session.remove("user"); // Xóa session của người dùng
	    return "redirect:/account/login"; // Chuyển hướng về trang đăng nhập
	}


}
