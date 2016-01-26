package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Passport implements Serializable {

    public static final long serialVersionUID = 1L;

    private long id;
    private String series;
    private String number;
    private String placeOfIssue;
    private Date dateOfIssue;
    private String residence;

    protected Passport() {
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
    @Column(name = "series", nullable = false, insertable = true, updatable = true, length = 4)

    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }

    @Basic
    @Column(name = "number", nullable = false, insertable = true, updatable = true, length = 6)

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "place_of_issue", nullable = false, insertable = true, updatable = true, length = 200)

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }
    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    @Basic
    @Column(name = "date_of_issue", nullable = false, insertable = true, updatable = true)

    public Date getDateOfIssue() {
        return dateOfIssue;
    }
    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Basic
    @Column(name = "residence", nullable = false, insertable = true, updatable = true, length = 200)

    public String getResidence() {
        return residence;
    }
    public void setResidence(String residence) {
        this.residence = residence;
    }


}
