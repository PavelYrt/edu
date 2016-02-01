package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(optional = false)
    private Author author;

    @ManyToOne(optional = false)
    private Genre genre;

    @OneToOne(optional = false, mappedBy = "bookId")
    private BookCard bookCardId;

    private int pagecount;

    private String description;

    protected Book() {
    }

    public Book(String name, Author author, Genre genre, BookCard bookCardId, int pagecount, String description) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.bookCardId = bookCardId;
        this.pagecount = pagecount;
        this.description = description;
    }

    public Book(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BookCard getBookCardId() {
        return bookCardId;
    }

    public void setBookCardId(BookCard bookCardId) {
        this.bookCardId = bookCardId;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
