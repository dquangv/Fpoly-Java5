package com.poly.lab5.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.lab5.entity.Category;
import com.poly.lab5.repository.CategoryRepository;

import org.springframework.ui.Model;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/category/index")
	public String index(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("field") Optional<String> field) {
		Category category = new Category();
		model.addAttribute("item", category);
		Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Direction.ASC, field.orElse("id")));
		Page<Category> pages = categoryRepository.findAll(pageable);
		model.addAttribute("page", pages);
		return "category/index";
	}

	@RequestMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id, @RequestParam("page") Optional<Integer> page,
			@RequestParam("field") Optional<String> field) {
		Category item = categoryRepository.findById(id).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Direction.ASC, field.orElse("id")));
		Page<Category> pages = categoryRepository.findAll(pageable);
		model.addAttribute("page", pages);
		return "category/index";
	}

	@RequestMapping("/category/create")
	public String create(Category item) {
		categoryRepository.save(item);
		return "redirect:/category/index";
	}

	@RequestMapping("/category/update")
	public String update(Category item) {
		categoryRepository.save(item);
		return "redirect:/category/edit/" + item.getId();
	}

	@RequestMapping("/category/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		categoryRepository.deleteById(id);
		return "redirect:/category/index";
	}
}
