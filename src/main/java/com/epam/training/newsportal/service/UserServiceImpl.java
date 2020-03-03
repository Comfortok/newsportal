package com.epam.training.newsportal.service;

import com.epam.training.newsportal.dao.RoleDao;
import com.epam.training.newsportal.dao.UserDao;
import com.epam.training.newsportal.entity.Role;
import com.epam.training.newsportal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public void createUser(User user) {
        System.out.println("create user in UserService");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getRoleById(1L));
        System.out.println(roles);
        user.setRoles(roles);
        System.out.println("user.setRoles... ");
        userDao.createUser(user);
    }

    @Transactional
    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}