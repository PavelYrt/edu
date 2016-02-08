package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Passport implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private int series;

    private int number;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String placeOfIssue;

    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;

    private String residence;

    protected Passport() {
    }

    public Passport(int series, int number, String placeOfIssue, Date dateOfIssue, String residence) {
        this.series = series;
        this.number = number;
        this.placeOfIssue = placeOfIssue;
        this.dateOfIssue = dateOfIssue;
        this.residence = residence;
    }

    public Passport(String placeOfIssue) { //todo Почему работает только с string конструктором? что тут, что в книге, что в юзере.
        this.placeOfIssue = placeOfIssue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", series=" + series +
                ", number=" + number +
                ", dateOfBirth=" + dateOfBirth +
                ", placeOfIssue='" + placeOfIssue + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", residence='" + residence + '\'' +
                '}';
    }
}
