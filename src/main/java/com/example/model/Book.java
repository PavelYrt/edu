package com.example.model;



import org.hibernate.annotations.NaturalId;

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
    private Author authorId;


    @ManyToOne(optional = false) //todo try to use this attribute: fetch = FetchType.EAGER
    private Genre genreId;

    private int pagecount;

    private String description;

    public Book(Long id, String name, Author authorId, Genre genreId, int pagecount, String description) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.genreId = genreId;
        this.pagecount = pagecount;
        this.description = description;
    }

    protected Book() {
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

    public Author getAuthorId() {

        return authorId;
    }

    public void setAuthorId(String fio) {
        this.authorId.setFio(fio);;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(String name) {
        this.genreId.setName(name);
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
