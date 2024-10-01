package com.poly.lab5.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.lab5.entity.Category;
import com.poly.lab5.entity.Product;
import com.poly.lab5.repository.CategoryRepository;
import com.poly.lab5.repository.ProductRepository;


@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/product/index")
	public String index(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		List<Product> list = productRepository.findAll();
		model.addAttribute("products", list);
		return "product/index";
	}
	
	@ModelAttribute("cateList")
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
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product item = productRepository.findById(id).get();
		model.addAttribute("product", item);
		List<Product> listProd = productRepository.findAll();
		model.addAttribute("products", listProd);
		return "product/index";
	}
	
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		productRepository.deleteById(id);
		return "redirect:/product/index";
	}
}
