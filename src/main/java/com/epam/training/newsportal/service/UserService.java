package com.epam.training.newsportal.service;

import com.epam.training.newsportal.entity.User;

public interface UserService {
    void createUser(User user);
    User getUserByEmail(String email);
}