package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.Article;

import java.util.List;

public interface ArticleDao {
    void createArticle(Article article);
    void removeArticle(long id);
    void editArticle(Article article);
    Article getArticleById(long id);
    List<Article> getAllArticles();
}