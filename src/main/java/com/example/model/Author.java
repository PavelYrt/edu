package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Author implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    public Long id;

    private String fio;

    private Date birthday;

    protected Author() {
    }

    public Author(String fio, Date birthday) {
        this.fio = fio;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return fio;
    }
}

