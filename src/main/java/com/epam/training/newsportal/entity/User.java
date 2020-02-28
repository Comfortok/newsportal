package com.epam.training.newsportal.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EMAIL")
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @Column(name = "PASSWORD")
    @NotEmpty(message = "Password can not be empty")
    private String password;

    @Transient
    Set<Article> articles;

    @Transient
    Set<Comment> comments;
}