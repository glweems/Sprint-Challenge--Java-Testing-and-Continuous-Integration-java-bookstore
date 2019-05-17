package com.lambdaschool.bookstore.controller;


import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "", produces = {"application/json"})
    public ResponseEntity<?> listBooks() {

        List<Book> allBooks = bookService.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
}
