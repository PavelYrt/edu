package com.example.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BookCard implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;
    private Long internalNumber;
    private Long bookId;

    protected BookCard() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "internal_number", nullable = false, insertable = true, updatable = true)
    public Long getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(Long internalNumber) {
        this.internalNumber = internalNumber;
    }

    @Basic
    @Column(name = "book_id", nullable = false, insertable = true, updatable = true)
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

}
