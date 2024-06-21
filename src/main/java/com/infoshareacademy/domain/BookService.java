package com.infoshareacademy.domain;

import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class BookService {
    Books books;
@Autowired
    public BookService(Books books) {
        this.books = books;
    }
    public List<Book> getBooks(){
      return books.getBooks();
    }
}
