package com.example.poly.interceptor;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.poly.entity.Account;
import com.example.poly.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    SessionService session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        Account user = (Account) session.get("user"); // lấy từ session
        String error = "";
        
        if (user == null) { // chưa đăng nhập
            error = "Please login!";
        } else if (!user.getAdmin() && (uri.startsWith("/doctors/saveOrUpdate") || uri.startsWith("/doctors/delete"))) {
            // Người dùng không phải admin và đang cố gắng thực hiện thao tác CRUD
        	session.remove("user"); // Đăng xuất bằng cách xóa thông tin người dùng
            error = "Access denied! You are logged out due to insufficient permissions.";
        }

        if (error.length() > 0) { // có lỗi
        	session.set("security-uri", "/doctors");
            response.sendRedirect("/account/login?error=" + error);
            return false;
        }
        return true;
    }

}
