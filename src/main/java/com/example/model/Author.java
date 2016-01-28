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

    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    protected Author() {
    }

    public Author(String fullName, Date birthday) {
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // #костыль. Возвращает fullName чтобы в grid вместо хэшкода класса
    // отображалось поле fullName таблицы authors
    @Override
    public String toString() {
        return fullName;
    }
}

