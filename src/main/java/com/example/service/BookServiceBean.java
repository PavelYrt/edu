package com.example.service;

import com.example.model.Book;
import com.example.model.Genre;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceBean implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Collection<Book> findAll() {

        Collection<Book> books = bookRepository.findAll();

        return books;
    }

    @Override
    public Book findOne(Long id) {

        Book book = bookRepository.findOne(id);

        return book;
    }

    @Override
    public Book create(Book book) {

        // Ensure the entity object to be created does NOT exist in the
        // repository. Prevent the default behavior of save() which will update
        // an existing entity if the entity matching the supplied id exists.

        Book savedBook = bookRepository.save(book);

        return savedBook;
    }



    @Override
    public Book update(Book book) {

        // Ensure the entity object to be updated exists in the repository to
        // prevent the default behavior of save() which will persist a new
        // entity if the entity matching the id does not exist
        Book genreToUpdate = findOne(book.getId());
        if (genreToUpdate == null) {
            // Cannot update Greeting that hasn't been persisted
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
