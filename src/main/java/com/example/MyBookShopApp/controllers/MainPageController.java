package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    @Autowired
    BookService bookService;

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookService);
        return "index";
    }
}
