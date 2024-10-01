package com.poly.lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.lab4.model.PhoneContact;
import com.poly.lab4.service.PhoneService;

@RestController
public class PhoneController {
	
	@Autowired
	PhoneService phoneService;
	
	@GetMapping("/addPhoneContact")
	public List<PhoneContact> addPhoneContact() {
		return phoneService.add(new PhoneContact("0202020202", "Tung", "bung bu", "HCM"));
	}
	
	@GetMapping("/updatePhoneContact/{phone}")
	public List<PhoneContact> updatePhoneContact(@PathVariable String phone) {
		return phoneService.update(phone, new PhoneContact("0303030303", "QB", "bung to", "Binh Thuan"));
	}
}
