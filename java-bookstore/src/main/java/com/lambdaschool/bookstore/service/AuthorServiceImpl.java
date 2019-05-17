package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll()
    {
        List<Author> list = new ArrayList<>();
        authorRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
