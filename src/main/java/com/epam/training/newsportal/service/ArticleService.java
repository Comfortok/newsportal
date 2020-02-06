package com.epam.training.newsportal.service;

import com.epam.training.newsportal.entity.Article;

import java.util.List;

public interface ArticleService {
    void createArticle(Article article);
    void removeArticle(int id);
    void editArticle(Article article);
    Article getArticleById(int id);
    List<Article> getAllArticles();
}