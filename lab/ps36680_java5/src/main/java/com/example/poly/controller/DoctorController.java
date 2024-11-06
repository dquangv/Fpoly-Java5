package com.example.poly.controller;

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

import com.example.poly.entity.Account;
import com.example.poly.entity.Doctor;
import com.example.poly.entity.Genre;
import com.example.poly.repository.DoctorRepository;
import com.example.poly.service.SessionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;
    
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
    public String saveOrUpdateDoctor(@Valid @ModelAttribute Doctor doctor, 
                                    BindingResult result, 
                                    @RequestParam String action, Model model) {
        Account user = (Account) session.get("user"); // Lấy user từ session
        if (user != null && user.getAdmin()) { // Chỉ cho phép admin thực hiện CRUD
        	if (result.hasErrors()) {
        	    model.addAttribute("errorMessages", result.getFieldErrors()
        	        .stream()
        	        .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        	    List<Doctor> doctorList = doctorRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
                model.addAttribute("doctorList", doctorList);
        	    model.addAttribute("action", "create");
        	    return "doctor/doctor"; // Trả về trang book để hiển thị lỗi
        	}


            if ("create".equals(action)) {
//                book.setTimePublished(LocalDateTime.now()); // Nếu cần, bạn có thể thiết lập thời gian hiện tại
            	doctorRepository.save(doctor);
            } else if ("edit".equals(action) && doctor.getId() != null) {
                Doctor existingDoctor = doctorRepository.findById(doctor.getId()).orElse(null);
                if (existingDoctor != null) {
                	existingDoctor.setLastName(doctor.getLastName());
                	existingDoctor.setFirstName(doctor.getFirstName());
                	existingDoctor.setSalary(doctor.getSalary());
                	existingDoctor.setHireDate(doctor.getHireDate());
//                    existingBook.setGenre(doctor.getGenre());
                	doctorRepository.save(existingDoctor);
                }
            } else if ("delete".equals(action) && doctor.getId() != null) {
            	doctorRepository.deleteById(doctor.getId());
            }
        }
        return "redirect:/doctors";
    }



    @GetMapping
    public String listDoctors(Model model) {
        List<Doctor> doctorList = doctorRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("doctorList", doctorList); // Thêm danh sách sách vào mô hình
        model.addAttribute("action", "create"); // Đặt action về create
        return "doctor/doctor"; // Trả về trang JSP quản lý sách
    }

    @PostMapping("/save")
    public String saveDoctor(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Double salary,
                           @RequestParam String hireDate) {
        Doctor doctor = new Doctor();
        doctor.setLastName(lastName);
        doctor.setFirstName(firstName);
        doctor.setSalary(salary);
        doctor.setHireDate(LocalDateTime.parse(hireDate)); // Chuyển đổi chuỗi thành LocalDateTime
//        doctor.setGenre(Genre.valueOf(genre)); // Chuyển đổi chuỗi thành Enum Genre

        doctorRepository.save(doctor); // Lưu sách vào cơ sở dữ liệu
        return "redirect:/doctors"; // Chuyển hướng về danh sách sách
    }

//    @GetMapping("/edit")
//    public String editBook(@RequestParam Long id, Model model) {
//        Book book = bookRepository.findById(id).orElse(null); // Tìm sách theo ID
//        if (book != null) {
//            model.addAttribute("book", book); // Thêm sách vào mô hình để hiển thị trong form
//        }
//        return "edit_book"; // Trả về trang chỉnh sửa sách
//    }

//    @PostMapping("/update")
//    public String updateBook(@RequestParam Long id,
//                             @RequestParam String title,
//                             @RequestParam String author,
//                             @RequestParam Double price,
//                             @RequestParam String timePublished,
//                             @RequestParam String genre) {
//        Doctor book = bookRepository.findById(id).orElse(null);
//        if (book != null) {
//            book.setTitle(title);
//            book.setAuthor(author);
//            book.setPrice(price);
//            book.setTimePublished(LocalDateTime.parse(timePublished));
//            book.setGenre(Genre.valueOf(genre));
//
//            bookRepository.save(book); // Cập nhật sách trong cơ sở dữ liệu
//        }
//        return "redirect:/books"; // Chuyển hướng về danh sách sách
//    }

    @GetMapping("/edit")
    public String editDoctor(@RequestParam Long id, Model model) {
        Doctor doctor = doctorRepository.findById(id).orElse(null); // Tìm sách theo ID
        if (doctor != null) {
            model.addAttribute("doctor", doctor); // Thêm sách vào mô hình để hiển thị trong form
        }
        model.addAttribute("action", "edit"); // Đặt action là 'edit'
        List<Doctor> doctorList = doctorRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("doctorList", doctorList); 
        return "doctor/doctor"; // Trả về trang quản lý sách với form có thông tin sách
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id, Model model) {
        Doctor doctor = doctorRepository.findById(id).orElse(null); // Tìm sách theo ID
        if (doctor != null) {
            model.addAttribute("doctor", doctor); // Thêm sách vào mô hình để hiển thị trong form
        }
        model.addAttribute("action", "delete"); // Đặt action là 'delete'
        List<Doctor> doctorList = doctorRepository.findAll(); // Lấy tất cả sách từ cơ sở dữ liệu
        model.addAttribute("doctorList", doctorList); 
        return "doctor/doctor"; // Trả về trang quản lý sách với form có thông tin sách
    }
    
    @PostMapping("/reset")
    public String resetForm(Model model) {
        // Tạo một đối tượng Book trống
        Doctor emptyDoctor = new Doctor();
        
        // Đặt book trống vào model
        model.addAttribute("doctor", emptyDoctor);
        
        
        return "redirect:/doctors";
    }
    
    @GetMapping("/search")
    public String searchBooks(@RequestParam(required = false) String search,  
                              @RequestParam(required = false) Double minPrice,
                              @RequestParam(required = false) Double maxPrice,
                              Model model) {
        List<Doctor> doctorList;

        // Trường hợp tìm kiếm theo title, author, genre và khoảng giá
        if (search != null && !search.isEmpty() && minPrice != null && maxPrice != null) {
            
//            doctorList = doctorRepository.findByTitleContainingOrAuthorContainingAndGenreAndPriceBetween(search, search, genre, minPrice, maxPrice);
            doctorList = doctorRepository.findByLastNameContainingOrFirstNameContainingAndSalaryBetween(search, search, minPrice, maxPrice);
        }
        // Trường hợp tìm kiếm theo title và author cùng với genre
//        else if (search != null && !search.isEmpty() && !"all".equals(filter)) {
//            Genre genre = Genre.valueOf(filter);
////            doctorList = doctorRepository.findByTitleContainingOrAuthorContaining(search, search);
//            doctorList = null;
//        }
        // Trường hợp tìm kiếm theo title và author
        else if (search != null && !search.isEmpty()) {
//        	doctorList = doctorRepository.findByTitleContainingOrAuthorContaining(search, search);
        	doctorList = doctorRepository.findByLastNameContainingOrFirstNameContaining(search, search);
        }
        // Các trường hợp khác giữ nguyên
//        else if (minPrice != null && maxPrice != null) {
////            Genre genre = Genre.valueOf(filter);
////            doctorList = doctorRepository.findByGenreAndPriceBetween(genre, minPrice, maxPrice);
//            doctorList = null;
         else if (minPrice != null && maxPrice != null) {
        	doctorList = doctorRepository.findBySalaryBetween(minPrice, maxPrice);
//        } else if (!"all".equals(filter)) {
//            Genre genre = Genre.valueOf(filter);
////            doctorList = doctorRepository.findByGenre(genre);
//            doctorList = null;
        } else {
        	doctorList = doctorRepository.findAll();
        }

        model.addAttribute("doctorList", doctorList);
        return "doctor/doctor"; // Trả về trang hiển thị sách
    }




}