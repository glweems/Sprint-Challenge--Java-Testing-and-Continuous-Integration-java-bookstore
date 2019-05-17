package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
