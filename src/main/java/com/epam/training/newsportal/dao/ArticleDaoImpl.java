package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.Article;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override//TODO user_id --> change
    public void createArticle(Article article) {
        entityManager.createNativeQuery("INSERT INTO ARTICLE(HEADER, TEXT, RELEASE_DATE, USER_ID) VALUES(?,?,?,?)")
                .setParameter(1, article.getHeader())
                .setParameter(2, article.getText())
                .setParameter(3, article.getReleaseDate())
                .setParameter(4, 1)
                .executeUpdate();
        System.out.println("Article dao. An article was created with header " + article.getHeader());
        logger.info("An article " + article + " is successfully created.");
    }

    @Override
    public void removeArticle(long id) {
        Article article = sessionFactory.getCurrentSession().load(Article.class, id);
        if (article != null) {
            this.sessionFactory.getCurrentSession().delete(article);
        }
        logger.info("An article with id " + id + " is successfully removed.");
    }

    @Override
    public void editArticle(Article article) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaUpdate<Article> update = criteriaBuilder.createCriteriaUpdate(Article.class);
        Root<Article> root = update.from(Article.class);
        update.set(root.get("header"), article.getHeader());
        update.set(root.get("text"), article.getText());
        update.set((root.get("releaseDate")), article.getReleaseDate());
        update.where(criteriaBuilder.equal(root.get("id"), article.getId()));
        this.entityManager.createQuery(update).executeUpdate();
        logger.info("An article with id " + article.getId() + " is successfully updated.");
    }

    @Override
    public Article getArticleById(long id) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("getAnArticleById");
        query.setParameter("id", id);
        Object result = query.getSingleResult();
        logger.info("An article is successfully loaded.");
        return (Article) result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles() {
        Query query = entityManager.createQuery("select e from Article e order by e.releaseDate desc");
        logger.info("All articles were selected.");
        return (List<Article>) query.getResultList();
    }
}