package com.infoshareacademy.domain;


import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public @ResponseBody Book showRandomBook(){
        Random rand = new Random();
        int zakres = bookService.getBooks().size();
        int index = rand.nextInt(zakres);
        return bookService.getBooks().get(index);
    }
}
