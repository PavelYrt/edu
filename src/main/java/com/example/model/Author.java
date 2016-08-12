package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Author implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    public Long id;

    private String authorFullName;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    protected Author() {
    }

    public Author(String authorFullName, Date birthday) {
        this.authorFullName = authorFullName;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return authorFullName;
    }
}

