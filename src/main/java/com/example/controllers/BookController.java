package com.example.controllers;

import com.example.model.Book;
import com.example.model.Passport;
import com.example.model.User;
import com.example.repository.PassportRepository;
import com.example.repository.UserRepository;
import com.example.service.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibraryServices<Book, Long> bookService;

    @RequestMapping("/passports")
    public List<Passport> getPassport() {
        return passportRepository.findAll();
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(
            value = "/book",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Book>> getBook() {
        Collection<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/book/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        Book book = bookService.findOne(id);
        if (book == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/book",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(
            @RequestBody Book book) {
        book = bookService.create(book);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/book/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.update(book);
        if (updatedBook == null) {
            return new ResponseEntity<Book>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/book/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id, @RequestBody Book book) {
        bookService.delete(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
}
