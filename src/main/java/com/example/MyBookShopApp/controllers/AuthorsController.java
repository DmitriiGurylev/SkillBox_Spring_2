package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class AuthorsController {

    @Autowired
    BookService bookService;

    @GetMapping("/authors")
    public String authorsPage(Model model){
//        model.addAttribute("authorData", bookService.getAuthorsData());

        Map<Character, LinkedList<Author>> firstLetterAuthors = new HashMap<>();
        bookService.getAuthorsData()
                .forEach(ad -> {
                    char ch = ad.getName().charAt(0);
                    LinkedList<Author> ll;
                    if (firstLetterAuthors.containsKey(ch)) {
                        ll = firstLetterAuthors.get(ch);
                        ll.add(ad);
                    } else {
                        ll = new LinkedList<>();
                        ll.add(ad);
                        firstLetterAuthors.put(ch, ll);
                    }
                });
        model.addAttribute("authorData", firstLetterAuthors);


        return "authors/index";
}
}
