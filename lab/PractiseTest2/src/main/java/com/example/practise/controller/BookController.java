package com.example.practise.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.practise.entity.Account;
import com.example.practise.entity.Book;
import com.example.practise.entity.Genre;
import com.example.practise.repository.BookRepository;
import com.example.practise.service.SessionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private SessionService session;
    
//    @PostMapping("/saveOrUpdate")
//    public String saveOrUpdateBook(@RequestParam(required = false) Long id,
//                                    @RequestParam String title,
//                                    @RequestParam String author,
//                                    @RequestParam Double price,
//                                    @RequestParam String timePublished,
//                                    @RequestParam String genre,
//                                    @RequestParam String action) {
//        Account user = (Account) session.get("user"); // Lấy user từ session
//        if (user != null && user.getAdmin()) { // Chỉ cho phép admin thực hiện CRUD
//            if ("create".equals(action)) {
//                Book book = new Book();
//                book.setTitle(title);
//                book.setAuthor(author);
//                book.setPrice(price);
//                book.setTimePublished(LocalDateTime.parse(timePublished));
//                book.setGenre(Genre.valueOf(genre));
//                bookRepository.save(book);
//            } else if ("edit".equals(action) && id != null) {
//                Book book = bookRepository.findById(id).orElse(null);
//                if (book != null) {
//                    book.setTitle(title);
//                    book.setAuthor(author);
//                    book.setPrice(price);
//                    book.setTimePublished(LocalDateTime.parse(timePublished));
//                    book.setGenre(Genre.valueOf(genre));
//                    bookRepository.save(book);
//                }
//            } else if ("delete".equals(action) && id != null) {
//                bookRepository.deleteById(id);
//            }
//        }
//        return "redirect:/books";
//    }
    
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateBook(@Valid @ModelAttribute Book book, 
                                    BindingResult result, 
                                    @RequestParam String action, Model model) {
        Account user = (Account) session.get("user"); // Lấy user từ session
        if (user != null && user.getAdmin()) { // Chỉ cho phép admin thực hiện CRUD
        	if (result.hasErrors()) {
        	    model.addAttribute("errorMessages", result.getFieldErrors()
        	        .stream()
        	        .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        	    List<Book> bookList = bookRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
                model.addAttribute("bookList", bookList);
        	    model.addAttribute("action", "create");
        	    return "book/book"; // Trả về trang book để hiển thị lỗi
        	}


            if ("create".equals(action)) {
                book.setTimePublished(LocalDateTime.now()); // Nếu cần, bạn có thể thiết lập thời gian hiện tại
                bookRepository.save(book);
            } else if ("edit".equals(action) && book.getId() != null) {
                Book existingBook = bookRepository.findById(book.getId()).orElse(null);
                if (existingBook != null) {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setPrice(book.getPrice());
                    existingBook.setTimePublished(book.getTimePublished());
                    existingBook.setGenre(book.getGenre());
                    bookRepository.save(existingBook);
                }
            } else if ("delete".equals(action) && book.getId() != null) {
                bookRepository.deleteById(book.getId());
            }
        }
        return "redirect:/books";
    }



    @GetMapping
    public String listBooks(Model model) {
        List<Book> bookList = bookRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("bookList", bookList); // Thêm danh sách sách vào mô hình
        model.addAttribute("action", "create"); // Đặt action về create
        return "book/book"; // Trả về trang JSP quản lý sách
    }

    @PostMapping("/save")
    public String saveBook(@RequestParam String title,
                           @RequestParam String author,
                           @RequestParam Double price,
                           @RequestParam String timePublished,
                           @RequestParam String genre) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setTimePublished(LocalDateTime.parse(timePublished)); // Chuyển đổi chuỗi thành LocalDateTime
        book.setGenre(Genre.valueOf(genre)); // Chuyển đổi chuỗi thành Enum Genre

        bookRepository.save(book); // Lưu sách vào cơ sở dữ liệu
        return "redirect:/books"; // Chuyển hướng về danh sách sách
    }

//    @GetMapping("/edit")
//    public String editBook(@RequestParam Long id, Model model) {
//        Book book = bookRepository.findById(id).orElse(null); // Tìm sách theo ID
//        if (book != null) {
//            model.addAttribute("book", book); // Thêm sách vào mô hình để hiển thị trong form
//        }
//        return "edit_book"; // Trả về trang chỉnh sửa sách
//    }

    @PostMapping("/update")
    public String updateBook(@RequestParam Long id,
                             @RequestParam String title,
                             @RequestParam String author,
                             @RequestParam Double price,
                             @RequestParam String timePublished,
                             @RequestParam String genre) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            book.setTimePublished(LocalDateTime.parse(timePublished));
            book.setGenre(Genre.valueOf(genre));

            bookRepository.save(book); // Cập nhật sách trong cơ sở dữ liệu
        }
        return "redirect:/books"; // Chuyển hướng về danh sách sách
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null); // Tìm sách theo ID
        if (book != null) {
            model.addAttribute("book", book); // Thêm sách vào mô hình để hiển thị trong form
        }
        model.addAttribute("action", "edit"); // Đặt action là 'edit'
        List<Book> bookList = bookRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("bookList", bookList); 
        return "book/book"; // Trả về trang quản lý sách với form có thông tin sách
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null); // Tìm sách theo ID
        if (book != null) {
            model.addAttribute("book", book); // Thêm sách vào mô hình để hiển thị trong form
        }
        model.addAttribute("action", "delete"); // Đặt action là 'delete'
        List<Book> bookList = bookRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("bookList", bookList); 
        return "book/book"; // Trả về trang quản lý sách với form có thông tin sách
    }
    
    @PostMapping("/reset")
    public String resetForm(Model model) {
        // Tạo một đối tượng Book trống
        Book emptyBook = new Book();
        
        // Đặt book trống vào model
        model.addAttribute("book", emptyBook);
        
        
        return "redirect:/books";
    }
    
    @GetMapping("/search")
    public String searchBooks(@RequestParam(required = false) String search, 
                              @RequestParam(required = false) String filter, 
                              @RequestParam(required = false) Double minPrice,
                              @RequestParam(required = false) Double maxPrice,
                              Model model) {
        List<Book> bookList;

        // Trường hợp tìm kiếm theo title, author, genre và khoảng giá
        if (search != null && !search.isEmpty() && !"all".equals(filter) && minPrice != null && maxPrice != null) {
            Genre genre = Genre.valueOf(filter);
            bookList = bookRepository.findByTitleContainingOrAuthorContainingAndGenreAndPriceBetween(search, search, genre, minPrice, maxPrice);
        }
        // Trường hợp tìm kiếm theo title và author cùng với genre
        else if (search != null && !search.isEmpty() && !"all".equals(filter)) {
            Genre genre = Genre.valueOf(filter);
            bookList = bookRepository.findByTitleContainingOrAuthorContaining(search, search);
        }
        // Trường hợp tìm kiếm theo title và author
        else if (search != null && !search.isEmpty()) {
            bookList = bookRepository.findByTitleContainingOrAuthorContaining(search, search);
        }
        // Các trường hợp khác giữ nguyên
        else if (!"all".equals(filter) && minPrice != null && maxPrice != null) {
            Genre genre = Genre.valueOf(filter);
            bookList = bookRepository.findByGenreAndPriceBetween(genre, minPrice, maxPrice);
        } else if (minPrice != null && maxPrice != null) {
            bookList = bookRepository.findByPriceBetween(minPrice, maxPrice);
        } else if (!"all".equals(filter)) {
            Genre genre = Genre.valueOf(filter);
            bookList = bookRepository.findByGenre(genre);
        } else {
            bookList = bookRepository.findAll();
        }

        model.addAttribute("bookList", bookList);
        return "book/book"; // Trả về trang hiển thị sách
    }




}