package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BookCard implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private Long internalNumber;

    private Long bookId;

    protected BookCard() {
    }

    public BookCard(Long internalNumber, Long bookId) {
        this.internalNumber = internalNumber;
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(Long internalNumber) {
        this.internalNumber = internalNumber;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
