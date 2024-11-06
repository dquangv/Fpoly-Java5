package com.example.practise.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterConfig implements WebMvcConfigurer {
	@Autowired
	AuthInterceptor auth;

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auth)
                .addPathPatterns("/books/**", "/account/**") // Thêm tất cả các đường dẫn cần kiểm tra
                .excludePathPatterns("/assets/**", "/account/login", "/admin/index"); // Đường dẫn không cần kiểm tra
    }
}
