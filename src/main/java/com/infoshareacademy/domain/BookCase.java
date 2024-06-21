package com.infoshareacademy.domain;

import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookCase {
    BookService bookService;
@Autowired
    public BookCase(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path="/books")
     public @ResponseBody List<Book> showBooks(){
         return bookService.getBooks();
    }
}
