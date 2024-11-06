package com.example.lab7.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.lab7.dao.CategoryDAO;
import com.example.lab7.model.Category;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryRepository;
	
	
	@RequestMapping("/category/index")
	public String index(Model model, 
	                    @RequestParam("page") Optional<Integer> page,
	                    @RequestParam("field") Optional<String> field,
	                    @RequestParam("sortDir") Optional<String> sortDir) {
	    
	    Category category = new Category();
	    model.addAttribute("item", category);
	    
	    String sortDirection = sortDir.orElse("asc").equals("desc") ? "desc" : "asc";

	    String sortField = field.orElse("id");
	    
	    Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
	    Page<Category> pages = categoryRepository.findAll(pageable);
	    model.addAttribute("page", pages);
	    model.addAttribute("currentSortField", sortField);
	    model.addAttribute("currentSortDir", sortDirection);
	    return "category/index";
	}


	@RequestMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id, 
	                   @RequestParam("page") Optional<Integer> page,
	                   @RequestParam("field") Optional<String> field) {
	    // Lấy đối tượng Category từ CSDL
	    Category item = categoryRepository.findById(id).get();
	    
	    // Đưa đối tượng này vào model để đổ dữ liệu lên form
	    model.addAttribute("item", item);
	    
	    // Lấy danh sách danh mục để đổ vào table
	    Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Direction.ASC, field.orElse("id")));
	    Page<Category> pages = categoryRepository.findAll(pageable);
	    model.addAttribute("page", pages);
	    
	    // Vẫn trả về cùng view category/index
	    return "category/index";
	}


	@RequestMapping("/category/create")
	public String create(@Valid @ModelAttribute("item") Category item, BindingResult result, Model model, 
	                     @RequestParam("page") Optional<Integer> page,
	                     @RequestParam("field") Optional<String> field) {
	    if (result.hasErrors()) {
	        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Direction.ASC, field.orElse("id")));
	        Page<Category> pages = categoryRepository.findAll(pageable);
	        model.addAttribute("page", pages);
	        return "category/index";
	    }

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
