package com.poly.lab5.controller;

import com.poly.lab5.entity.Account;
import com.poly.lab5.entity.OrderDetail;
import com.poly.lab5.entity.Product;
import com.poly.lab5.entity.Report;
import com.poly.lab5.repository.AccountRepository;
import com.poly.lab5.repository.OrderDetailRepository;
import com.poly.lab5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductRepository productRepository;

    @ResponseBody
    @GetMapping("/findByPriceBetween")
    public List<Product> findByPriceBetween(@Param("min") Double min, @Param("max") Double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    @ResponseBody
    @GetMapping("/findByNameContaining")
    public List<Product> findByNameContaining(@Param("name") String name) {
        return productRepository.findByNameContaining(name);
    }

    @ResponseBody
    @GetMapping("/getReport")
    public List<Report> getReport() {
        return productRepository.getReport();
    }

    @ResponseBody
    @GetMapping("/findHighestValueOrder")
    public List<OrderDetail> findHighestValueOrder() {
        return orderDetailRepository.findHighestValueOrder();
    }

    @ResponseBody
    @GetMapping("/findLowestValueOrder")
    public List<OrderDetail> findLowestValueOrder() {
        return orderDetailRepository.findLowestValueOrder();
    }

    @ResponseBody
    @GetMapping("/findCustomerWithHighestTotalSpent")
    public Account findCustomerWithHighestTotalSpent() {
        return accountRepository.findCustomerWithHighestTotalSpent();
    }

    @ResponseBody
    @GetMapping("/findTopNBestSellingProducts")
    public List<Product> findTopNBestSellingProducts(
            @Param("beginDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
            @Param("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @Param("n") int n) {
        return productRepository.findTopNBestSellingProducts(beginDate, endDate, n);
    }

}
