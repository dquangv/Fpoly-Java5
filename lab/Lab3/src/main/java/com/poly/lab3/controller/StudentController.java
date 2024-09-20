package com.poly.lab3.controller;

import com.poly.lab3.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/form")
    public String form(@ModelAttribute("student") Student sv) {
        return "student/form";
    }

    @RequestMapping("/save")
    public String save(Model model, @Validated @ModelAttribute("student") Student sv, BindingResult result) {
        if (result.hasErrors()) {
        } else {
            model.addAttribute("message", "Thông tin hợp lệ");
        }

        return "student/form";
    }

    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> genders = new HashMap<Boolean, String>();
        genders.put(true, "Male");
        genders.put(false, "Female");

        return genders;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculties() {
        return Arrays.asList("CNTT","DLNHKS","QTDN");
    }

    @ModelAttribute("hobbies")
    public Map<String,String> getHobbies(){
        Map<String,String> hobbies = new HashMap<String,String>();
        hobbies.put("T","Travelling");
        hobbies.put("M","Music");
        hobbies.put("F","Food");
        hobbies.put("O","Other");

        return hobbies;
    }
}
