package com.epam.training.newsportal.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "ARTICLE")
public class Article {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "HEADER")
    @Size(min=2, message = "Can not be less than 2 symbols")
    @NotEmpty(message = "Title can not be empty")
    private String header;

    @Column(name = "TEXT")
    @Size(min=1)
    private String text;

    @Column(name = "RELEASE_DATE")
    //@Size(min=1)
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}