package com.example.service;

import com.example.model.Book;
import com.example.model.Genre;
import java.util.Collection;

public interface BookService {

    Collection<Book> findAll();

    Book findOne(Long id);

    Book create(Book book);

    Book update(Book book);

    void delete(Long id);

}
