package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createUser(User user) {
        System.out.println("creating user in dao");
        entityManager.createNativeQuery("INSERT INTO USER (EMAIL, PASSWORD) VALUES(?,?)")
                .setParameter(1, user.getEmail())
                .setParameter(2, user.getPassword())
                .executeUpdate();
        System.out.println("User dao. A user was created with email " + user.getEmail());
    }

    @Override
    public User getUserByEmail(String email) {
        return sessionFactory.getCurrentSession().get(User.class, email);
    }
}