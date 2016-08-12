package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceBean implements LibraryServices<Book, Long> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book genreToUpdate = findOne(book.getId());
        if (genreToUpdate == null) {
            return null;
        }

        genreToUpdate.setName(book.getName());
        return bookRepository.save(genreToUpdate);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }
}
