package com.poly.lab2.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.lab2.model.Country;
import com.poly.lab2.model.Maker;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PhoneController {
	@Autowired
    ServletContext app;
	@Autowired
    HttpServletRequest req;
	
	@GetMapping("/smartphone")
	public String addPhone() {
		return "phone";
	}

	@PostMapping("/smartphone_detail")
	public String getPhone(@RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("maker") String makerStr, @RequestParam("country") String countryStr,
			@RequestParam("image") MultipartFile image) throws IOException{
		req.setAttribute("name", name);
		req.setAttribute("price", price);
		Maker maker = Maker.valueOf(makerStr);
	    req.setAttribute("maker", maker);

	    Country country = Country.valueOf(countryStr);
	    req.setAttribute("country", country);

		if (!image.isEmpty()) {
            String uploadDirectory = app.getRealPath("/uploads/");
            File dir = new File(uploadDirectory);
            if (!dir.exists()) {
                dir.mkdirs(); 
            }

            String filePath = uploadDirectory + image.getOriginalFilename();
            File file = new File(filePath);
            image.transferTo(file);

            req.setAttribute("uploadedImage", file.getName());
        }
		
		return "phone_resp";
	}
}
