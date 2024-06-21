package com.infoshareacademy.domain;

import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FindBook {
    BookService bookService;
    @Autowired
    public FindBook(BookService bookService) {
        this.bookService = bookService;
    }

    private boolean containsString(String text, String textToFind){
        Pattern pattern = Pattern.compile(textToFind, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    @GetMapping(path="/book/{title}/search")
    public String getBooks1(@PathVariable("title") String title, Model model) {
        // get product by ID
        List<Book> foundBooks = new ArrayList<>();
        for(Book book: bookService.getBooks()){
            if(containsString(book.getTitle(), title))
                foundBooks.add(book);
        }
        model.addAttribute("books", foundBooks);
        model.addAttribute("search", "find text: " +title);
        return "books1h";
    }
}

