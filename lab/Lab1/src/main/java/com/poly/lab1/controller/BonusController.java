package com.poly.lab1.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BonusController {
    @Autowired
    ServletContext app;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest req;
    @Autowired
    HttpServletResponse resp;

    @GetMapping("/bonus")
    public String loadPage() {
        return "bonus";
    }

    @PostMapping("/process")
    public String processForm(
        @RequestParam("message") String message,
        @RequestParam("session") String sessionAttr,
        @RequestParam("application") String application,
        @RequestParam("image") MultipartFile image
    ) throws IOException {
        session.setAttribute("sessionAttr", sessionAttr);
        req.setAttribute("message", message);
        app.setAttribute("application", application);
        
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
        
        return "bonus-resp";
    }
}
