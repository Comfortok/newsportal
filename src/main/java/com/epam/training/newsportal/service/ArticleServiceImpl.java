package com.epam.training.newsportal.service;

import com.epam.training.newsportal.dao.ArticleDao;
import com.epam.training.newsportal.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    @Transactional
    public void createArticle(Article article) {
        this.articleDao.createArticle(article);
    }

    @Override
    @Transactional
    public void removeArticle(int id) {
        this.articleDao.removeArticle(id);
    }

    @Override
    @Transactional
    public void editArticle(Article article) {
        this.articleDao.editArticle(article);
    }

    @Override
    @Transactional
    public Article getArticleById(int id) {
        return this.articleDao.getArticleById(id);
    }

    @Override
    @Transactional
    public List<Article> getAllArticles() {
        return this.articleDao.getAllArticles();
    }
}