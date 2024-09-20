package com.poly.lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.lab2.model.Country;
import com.poly.lab2.model.Maker;
import com.poly.lab2.model.Phone;
import com.poly.lab2.repository.PhoneRepository;
import com.poly.lab2.util.FileUploadUtil;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PhoneController {

	@Autowired
	private PhoneRepository phoneRepository;

	// Display the list of phones
	@GetMapping("/phones")
	public String listPhones(Model model) {
		List<Phone> phones = phoneRepository.findAll();
		model.addAttribute("phoneList", phones);
		model.addAttribute("makers", Maker.values());
		model.addAttribute("countries", Country.values());
		return "phone-management";
	}

	// Handle form submission for adding a phone
	@PostMapping("/phones/add")
	public String addPhone(@ModelAttribute("phone") Phone phone, HttpServletRequest req) throws IOException {
		phoneRepository.save(phone);
		return "redirect:/phones";
	}

	// Show form to edit a phone (data is fetched for editing in the same view)
	@GetMapping("/phones/edit/{id}")
	public String showEditPhoneForm(@PathVariable("id") Integer id, Model model) {
		Phone phone = phoneRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid phone Id:" + id));

		model.addAttribute("phoneToEdit", phone);
		model.addAttribute("phoneList", phoneRepository.findAll());
		model.addAttribute("makers", Maker.values());
		model.addAttribute("countries", Country.values());

		return "phone-management";
	}

	// Handle form submission for updating a phone
	@PostMapping("/phones/edit")
	public String updatePhone(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("price") double price, @RequestParam("maker") Maker maker,
			@RequestParam("country") Country country) {

		Phone existingPhone = phoneRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid phone Id:" + id));

		existingPhone.setName(name);
		existingPhone.setPrice(price);
		existingPhone.setMaker(maker);
		existingPhone.setCountry(country);

		phoneRepository.save(existingPhone);
		return "redirect:/phones";
	}

	// Handle deletion of a phone
	@PostMapping("/phones/delete")
	public String deletePhone(@RequestParam("id") Integer id) {
		Phone phone = phoneRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid phone Id:" + id));
		phoneRepository.delete(phone);
		return "redirect:/phones";
	}

}
