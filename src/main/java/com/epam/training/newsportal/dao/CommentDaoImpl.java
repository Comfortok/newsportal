package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.entity.Comment;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    private static final Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createComment(Comment comment, int id) {
        entityManager.createNativeQuery("INSERT INTO COMMENTS(TEXT, ARTICLE_ID) VALUES(?, ?)")
                .setParameter(1, comment.getText())
                .setParameter(2, comment.getArticle().getId())
                .executeUpdate();
        System.out.println("Comment dao. Comment was created with id " + comment.getId());
        logger.info("Comment " + comment + " is successfully created.");
    }

    @Override
    public void removeComment(int id) {
        Comment comment = getCommentById(id);
        sessionFactory.getCurrentSession().delete(comment);
    }

    @Override
    public void editComment(Comment comment) {
        sessionFactory.getCurrentSession().merge(comment);
    }

    @Override
    public Comment getCommentById(int id) {
        return sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    @Override
    public List<Comment> getAllComments(Article article) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("getCommentsByArticleId");
        query.setParameter("id", article.getId());
        List<Comment> result = query.getResultList();
        logger.info("An article is successfully loaded.");
        return result;

       /* System.out.println("getAllComments starts");
        Query query = entityManager.createQuery("SELECT e from Comment e where e.article.id = :id");
        System.out.println("63");
        query.setParameter("id", article.getId());
        System.out.println("65");
        logger.info("All comments were selected.");
        return (List<Comment>) query.getResultList();*/
    }
}