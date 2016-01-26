package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String fio;

    @ManyToOne
    private Passport passportId;

    public User(String fio, Passport passportId) {
        this.fio = fio;
        this.passportId = passportId;
    }

    protected User() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Passport getPassportId() {
        return passportId;
    }

    public void setPassportId(Passport passportId) {
        this.passportId = passportId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
