package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CardEntry implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private long bookCardId;

    private long userId;

    private String entryType;

    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @Temporal(TemporalType.DATE)
    private Date dateIn;

    protected CardEntry() {
    }

    public CardEntry(long bookCardId, long userId, String entryType, Date dateOut, Date dateIn) {
        this.bookCardId = bookCardId;
        this.userId = userId;
        this.entryType = entryType;
        this.dateOut = dateOut;
        this.dateIn = dateIn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookCardId() {
        return bookCardId;
    }

    public void setBookCardId(long bookCardId) {
        this.bookCardId = bookCardId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }
}
