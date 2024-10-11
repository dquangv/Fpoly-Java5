package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/product/index")
	public String index(Model model, 
                    @RequestParam("page") Optional<Integer> page,
                    @RequestParam("field") Optional<String> field,
                    @RequestParam("sortDir") Optional<String> sortDir,
                    @RequestParam("keyword") Optional<String> keyword) {
    Product product = new Product();
    model.addAttribute("product", product);
    
    model.addAttribute("keyword", keyword.orElse(""));

    String sortDirection = sortDir.orElse("asc").equals("desc") ? "desc" : "asc";
    String sortField = field.orElse("id");
    
    Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
    Page<Product> pages;
    if (keyword.isPresent()) {
        pages = productRepository.searchProducts(keyword.get(), pageable);
    } else {
        pages = productRepository.findAll(pageable);
    }
    model.addAttribute("page", pages);
    model.addAttribute("currentSortField", sortField);
    model.addAttribute("currentSortDir", sortDirection);

    	return "product/index";
	}
	
	@ModelAttribute("/cateList")
	public List<Category> getCategories(){
		List<Category> list = categoryRepository.findAll();
		return list;
	}
	
	@RequestMapping("/product/create")
	public String create(Product product) {
		productRepository.save(product);
		return "redirect:/product/index";
	}
	
	@RequestMapping("/product/update")
	public String update(Product product) {
		productRepository.save(product);
		return "redirect:/product/edit/" + product.getId();
	}
	
	@RequestMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id, 
	                    @RequestParam("page") Optional<Integer> page,
	                    @RequestParam("field") Optional<String> field) {
		Product item = productRepository.findById(id).get();
		model.addAttribute("product", item);
		Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Direction.ASC, field.orElse("id")));
		Page<Product> pages = productRepository.findAll(pageable);
		model.addAttribute("page", pages);
		return "product/index";
	}
	
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		productRepository.deleteById(id);
		return "redirect:/product/index";
	}
}