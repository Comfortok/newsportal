package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.Article;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createArticle(Article article) {
        sessionFactory.getCurrentSession().saveOrUpdate(article);
        System.out.println("Article dao. An article was created");
        logger.info("An article " + article + " is successfully created.");
    }

    @Override
    public void removeArticle(int id) {
        Article article = sessionFactory.getCurrentSession().load(Article.class, id);
        if (article != null) {
            this.sessionFactory.getCurrentSession().delete(article);
        }
        logger.info("An article " + article + " is successfully removed.");
    }

    @Override
    public void editArticle(Article article) {
        sessionFactory.getCurrentSession().update(article);
        logger.info("An article " + article + " is successfully updated.");
    }

    @Override
    public Article getArticleById(int id) {
        logger.info("An article is successfully loaded.");
        return sessionFactory.getCurrentSession().get(Article.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles() {
        return sessionFactory.getCurrentSession().createQuery("from Article").list();
    }
}