package com.epam.training.newsportal.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "EMAIL", nullable = false)
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @NotEmpty(message = "Password can not be empty")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles = new HashSet<>();

    @OneToMany
    Set<Article> articles;

    @OneToMany
    Set<Comment> comments;
}