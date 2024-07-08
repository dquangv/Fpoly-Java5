package com.poly.lab1.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeServlet {
    private static final int MAX_AGE_SECONDS = 60 * 60 * 24; // 24h in seconds

    @Autowired
    ServletContext application;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @RequestMapping("/login")
    public String sayHello() {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("user", username);
        request.setAttribute("pass", password);
        application.setAttribute("courseInfo", "Java 5 SpringBoot Web Application");



        Cookie[] myCookie = request.getCookies();

        String cookieValue = "";

        boolean found = false;
        if (myCookie != null) {
            for (Cookie c : myCookie) {
                if (c.getName().equals("user")) {
                    cookieValue = c.getValue();
                    cookieValue = cookieValue.replaceAll("%20", " ");
                    request.setAttribute("userCookie", cookieValue);
                    found = true;
                }
                System.out.println(c.getAttribute("userCookie"));

                System.out.println(c.getValue());
            }
        }

        if (!found) {
            Cookie c = createCookie("user", "Lab 1 Bài 4.2");
            response.addCookie(c);
        }

        return "login-form";
    }

    private Cookie createCookie(String cookieName, String cookieValue) {
        try {
            cookieValue = java.net.URLEncoder.encode(cookieValue, "utf-8").replaceAll("\\+", "%20");
        } catch (Exception e) {
        }

        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(MAX_AGE_SECONDS);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        return cookie;
    }
}
