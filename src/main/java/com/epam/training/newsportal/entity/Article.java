package com.epam.training.newsportal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "article")
@NamedQuery(name = "getAnArticleById", query = "SELECT e from Article e where e.id = :id")
public class Article {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "HEADER")
    @Size(min=2, max=100, message = "Can not be less than 2 symbols")
    @NotEmpty(message = "Title can not be empty")
    private String header;

    @Column(name = "TEXT")
    @Size(min=2, max=2548, message = "Can not be less than 2 symbols")
    @NotEmpty(message = "Text can not be empty")
    private String text;

    @Column(name = "RELEASE_DATE")
    @NotNull(message = "Date can not be empty")
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Transient
    private Set<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}