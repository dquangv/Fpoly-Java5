package com.example.lab7.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab7.dao.AccountDAO;
import com.example.lab7.dao.CategoryDAO;
import com.example.lab7.model.Account;
import com.example.lab7.model.Category;
import com.example.lab7.service.SessionService;




@Controller
public class AccountController {
	@Autowired
	SessionService sessionService;
	@Autowired
	AccountDAO dao;
	
	@GetMapping("/account/login")
	public String view() {
		return "account/login";
	}
	
	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			Account user = dao.findByUsername(username);
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
					return "redirect:/category/index";
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
	
//	@Autowired
//	CategoryDAO cateDAO;
//
//	@RequestMapping("/category/index")
//	public String index(Model model, @RequestParam("page") Optional<Integer> page,
//			@RequestParam("field") Optional<String> field) {
//		Category category = new Category();
//		model.addAttribute("item", category);
//		Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Direction.ASC, field.orElse("id")));
//		Page<Category> pages = cateDAO.findAll(pageable);
//		model.addAttribute("page", pages);
//		return "category/index";
//	}
//
//	@RequestMapping("/category/edit/{id}")
//	public String edit(Model model, @PathVariable("id") String id, @RequestParam("page") Optional<Integer> page,
//			@RequestParam("field") Optional<String> field) {
//		Category item = cateDAO.findById(id).get();
//		model.addAttribute("item", item);
//		Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Direction.ASC, field.orElse("id")));
//		Page<Category> pages = cateDAO.findAll(pageable);
//		model.addAttribute("page", pages);
//		return "category/index";
//	}
//
//	@RequestMapping("/category/create")
//	public String create(Category item) {
//		cateDAO.save(item);
//		return "redirect:/category/index";
//	}
//
//	@RequestMapping("/category/update")
//	public String update(Category item) {
//		cateDAO.save(item);
//		return "redirect:/category/edit/" + item.getId();
//	}
//
//	@RequestMapping("/category/delete/{id}")
//	public String delete(@PathVariable("id") String id) {
//		cateDAO.deleteById(id);
//		return "redirect:/category/index";
//	}
}
