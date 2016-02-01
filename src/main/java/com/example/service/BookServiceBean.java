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

        // Ensure the entity object to be created does NOT exist in the
        // repository. Prevent the default behavior of save() which will update
        // an existing entity if the entity matching the supplied id exists.
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {

        // Ensure the entity object to be updated exists in the repository to
        // prevent the default behavior of save() which will persist a new
        // entity if the entity matching the id does not exist
        Book genreToUpdate = findOne(book.getId());
        if (genreToUpdate == null) {
            // Cannot update Book that hasn't been persisted
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
