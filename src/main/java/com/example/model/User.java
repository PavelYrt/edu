package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String userFullName;

    @ManyToOne
    private Passport passport;

    public User(String userfullName, Passport passport) {
        this.userFullName = userfullName;
        this.passport = passport;
    }

    protected User() {
    }

    public User(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return userFullName;
    }
}
