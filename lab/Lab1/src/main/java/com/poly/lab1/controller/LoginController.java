package com.poly.lab1.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	private static final int MAX_AGE_SECONDS = 10 * 1 * 1;

	@Autowired
	ServletContext app;
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;

	@GetMapping("/login")
	public String loadPage() {
		app.setAttribute("title", "Java 5 Lab 1 - PS36680 - Vũ Đăng Quang");
		return "login-form";
	}
	
	@PostMapping("/login")
	public String login() {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (isUserLoggedIn()) {
			req.setAttribute("loginMessage", "Đã có tài khoản khác đăng nhập");

			return "login-form";
		} else {
			req.setAttribute("user", username);
			req.setAttribute("pass", password);

			Cookie loginCookie = createCookie("user", username);
			resp.addCookie(loginCookie);

			req.setAttribute("loginMessage", "Đăng nhập thành công");

			return "login-form";
		}
	}

	private boolean isUserLoggedIn() {
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					return true;
				}
			}
		}

		return false;
	}

	private Cookie createCookie(String cookieName, String cookieValue) {
		if (cookieValue != null) {
			try {
				cookieValue = java.net.URLEncoder.encode(cookieValue, "utf-8").replaceAll("\\+", "%2");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(MAX_AGE_SECONDS);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);

		return cookie;
	}
}
