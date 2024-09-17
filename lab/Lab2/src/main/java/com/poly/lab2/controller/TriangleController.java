package com.poly.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TriangleController {

	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;

	@GetMapping("triangle")
	public String loadPage() {
		return "triangle";
	}

	@PostMapping("/triangle")
	public String submit() {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int c = Integer.parseInt(req.getParameter("c"));
		int max = a;
		int square = 1;

		if (max < b) {
			if (max < c) {
				square = c * c - b * b - a * a;
			} else {
				square = b * b - a * a - c * c;
			}
		} else {
			square = a * a - b * b - c * c;
		}

		if (!(a + b > c && b + c > a && c + a > b)) {
			req.setAttribute("result", "số đo 3 cạnh không tạo nên 1 tam giác");
			return "triangle";
		}

		if (a == b && b == c) {
			req.setAttribute("result", "tam giác đều");
			return "triangle";
		}

		if (a == b || b == c || c == a) {
			if (square == 0) {
				req.setAttribute("result", "tam giác vuông cân");
				return "triangle";
			} else {
				req.setAttribute("result", "tam giác cân");
				return "triangle";
			}
		}

		if (square == 0) {
			req.setAttribute("result", "tam giác vuông");
			return "triangle";
		}
		
		req.setAttribute("result", "tam giác thường");
		return "triangle";
	}
}
