package com.poly.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.lab5.entity.Clazz;
import com.poly.lab5.repository.ClazzRepository;

@Controller
public class ClazzController {
	@Autowired
	ClazzRepository clazzRepository;
	
	@ResponseBody
	@GetMapping("/findClazzByName")
	public List<Clazz> findClazzByName() {
		return clazzRepository.findClazzByName("Mathematics");
	}
	
	@ResponseBody
	@GetMapping("/findClazzByNumberOfStudentsBetween")
	public List<Clazz> findClazzByNumberOfStudentsBetween() {
		return clazzRepository.findClazzByNumberOfStudentsBetween(25, 30);
	}
	
	@ResponseBody
	@GetMapping("/findClazzBySemester")
	public List<Clazz> findClazzBySemester() {
		return clazzRepository.findClazzBySemester("Fall 2024");
	}
	
	@ResponseBody
	@GetMapping("/findClazzByNameAndSemester")
	public List<Clazz> findClazzByNameAndSemester() {
		return clazzRepository.findClazzByNameAndSemester("Mathematics","Fall 2024");
	}
}
