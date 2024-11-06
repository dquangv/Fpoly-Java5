package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test.entity.Book;
import com.example.test.repository.BookRepository;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/index")
    public String bookIndex(Model model) {
        List<Book> books = bookRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("books", books); // Thêm vào model với tên "books"
        return "book/index"; // Trả về view danh sách sách
    }

    // Hiển thị form tạo sách
    @GetMapping("/create")
    public String createBookForm(Model model) {
        model.addAttribute("book", new Book()); // Đảm bảo book không null
        return "book/form"; // Trả về view form tạo sách
    }

    // Xử lý yêu cầu tạo sách
    @PostMapping("/create")
    public String createBook(@Validated @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Nếu có lỗi, trở về form và hiển thị thông báo lỗi
            model.addAttribute("books", bookRepository.findAll()); // Cập nhật danh sách sách
            return "book/form"; // Trả về view form tạo sách
        }
        bookRepository.save(book); // Lưu sách vào cơ sở dữ liệu
        return "redirect:/book/index"; // Chuyển hướng về danh sách sách
    }

    // Hiển thị form cập nhật sách
    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return "redirect:/book/index";
        }
        model.addAttribute("book", book);
        return "book/form"; // Trả về view form cập nhật sách
    }

    // Xử lý yêu cầu cập nhật sách
    @PostMapping("/update")
    public String updateBook(@Validated @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Nếu có lỗi, trở về form và hiển thị thông báo lỗi
            return "book/form"; // Trả về view form cập nhật sách
        }
        bookRepository.save(book); // Cập nhật sách vào cơ sở dữ liệu
        return "redirect:/book/index"; // Chuyển hướng về danh sách sách
    }

    // Xử lý yêu cầu xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id); // Xóa sách theo ID
        return "redirect:/book/index"; // Chuyển hướng về danh sách sách
    }
}
