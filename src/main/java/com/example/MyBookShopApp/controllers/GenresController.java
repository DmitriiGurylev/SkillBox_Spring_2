package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GenresController {

    @Autowired
    BookService bookService;

    @GetMapping("/genres")
    public String mainPage(Model model){
//        model.addAttribute("genreData", bookService.getGenresData());
        return "genres/index";
    }
}
