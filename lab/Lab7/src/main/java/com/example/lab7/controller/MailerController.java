package com.example.lab7.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.lab7.helper.MailerHelper;
import com.example.lab7.model.MailInfo;
import com.example.lab7.service.MailerService;

@Controller
@RequestMapping("mail")
public class MailerController {
	@Autowired
	MailerService mailer;

	@GetMapping("")
	public String view() {
		return "mail/index";
	}

	@PostMapping("/send")
	public String send(Model model, @RequestParam("To") String txtTo, 
	                   @RequestParam("CC") String txtCC,
	                   @RequestParam("BCC") String txtBCC, 
	                   @RequestParam("Subject") String txtSubject,
	                   @RequestParam("Content") String txtContent, 
	                   @RequestParam("file") MultipartFile multipartFile) 
	                   throws IOException {
	    MailerHelper helper = new MailerHelper();
	    List<File> files = new ArrayList<>();
	    String[] emailCC = helper.parseStringEmailToArray(txtCC);
	    String[] emailBCC = helper.parseStringEmailToArray(txtBCC);
	    MailInfo mail = new MailInfo();
	    mail.setTo(txtTo);
	    mail.setCc(emailCC);
	    mail.setBcc(emailBCC);
	    mail.setSubject(txtSubject);
	    mail.setBody(txtContent);
	    
	    if (!multipartFile.isEmpty()) {
	        File file = helper.convertMultipartFileToFile(multipartFile);
	        files.add(file);
	        mail.setFiles(files);
	    }

	    try {
	        mailer.send(mail);
	        model.addAttribute("message", "Mail sent successfully!");
	    } catch (Exception e) {
	        model.addAttribute("message", "Failed to send mail: " + e.getMessage());
	    }

	    return "mail/index"; 
	}

}
