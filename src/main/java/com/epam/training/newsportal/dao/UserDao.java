package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.User;

public interface UserDao {
    void createUser(User user);
    User getUserByEmail(String email);
}