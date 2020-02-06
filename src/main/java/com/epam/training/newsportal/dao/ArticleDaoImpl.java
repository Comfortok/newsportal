package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {
    private static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createArticle(Article article) {
        sessionFactory.getCurrentSession().saveOrUpdate(article);
        //Session session = this.sessionFactory.getCurrentSession();
        //session.persist(article);
        logger.info("An article " + article + " is successfully created.");
    }

    @Override
    public void removeArticle(int id) {
        //Session session = this.sessionFactory.getCurrentSession();
        //Article article = session.load(Article.class, id);
        Article article = sessionFactory.getCurrentSession().load(Article.class, id);
        if (article != null) {
            //session.delete(article);
            this.sessionFactory.getCurrentSession().delete(article);
        }
        logger.info("An article " + article + " is successfully removed.");
    }

    @Override
    public void editArticle(Article article) {
        //Session session = this.sessionFactory.getCurrentSession();
        //session.update(article);
        sessionFactory.getCurrentSession().update(article);
        logger.info("An article " + article + " is successfully updated.");
    }

    @Override
    public Article getArticleById(int id) {
        //Session session = this.sessionFactory.getCurrentSession();
        //Article article = session.load(Article.class, id);
        //logger.info("An article " + article + " is successfully loaded.");
        return sessionFactory.getCurrentSession().get(Article.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles() {
        return sessionFactory.getCurrentSession().createQuery("from Article").list();
        /*Session session = this.sessionFactory.getCurrentSession();
        List<Article> articles = session.createQuery("from Article").list();
        for (Article article : articles) {
            System.out.println(article + " loaded");
            logger.info("An article " + article + " is successfully loaded.");
        }
        return articles;*/
    }
}