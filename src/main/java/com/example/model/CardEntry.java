package com.example.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class CardEntry implements Serializable {
    public static final long serialVersionUID = 1L;

    private long id;

    private long bookCardId;
    private long userId;
    private String entryType;
    private Date dateOut;
    private Date dateIn;


    protected CardEntry() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_card_id", nullable = false, insertable = true, updatable = true)

    public long getBookCardId() {
        return bookCardId;
    }
    public void setBookCardId(long bookCardId) {
        this.bookCardId = bookCardId;
    }

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "entry_type", nullable = false, insertable = true, updatable = true, length = 45)

    public String getEntryType() {
        return entryType;
    }
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    @Basic
    @Column(name = "date_out", nullable = true, insertable = true, updatable = true)

    public Date getDateOut() {
        return dateOut;
    }
    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Basic
    @Column(name = "date_in", nullable = true, insertable = true, updatable = true)

    public Date getDateIn() {
        return dateIn;
    }
    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }


}
