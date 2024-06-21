package com.infoshareacademy.domain;


import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Controller
public class RandomBook {
    BookService bookService;
    @Autowired
    public RandomBook(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping(path="/book-for-today")
    public String showRandomBook(Model model){
        Random rand = new Random();
        int zakres = bookService.getBooks().size();
        int index = rand.nextInt(zakres);
        model.addAttribute("books", bookService.getBooks().get(index));
        model.addAttribute("search", "Book for today: ");
        return "books1h";
    }
}
