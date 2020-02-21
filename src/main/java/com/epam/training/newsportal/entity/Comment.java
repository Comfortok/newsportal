package com.epam.training.newsportal.entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTS")
@NamedQuery(name = "getCommentsByArticleId", query = "SELECT e from Comment e where e.article.id = :id")
public class Comment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TEXT")
    private String text;

    //@Column(name = "ARTICLE_ID")
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}