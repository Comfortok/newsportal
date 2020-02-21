package com.epam.training.newsportal.service;

import com.epam.training.newsportal.dao.CommentDao;
import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    @Transactional
    public void createComment(Comment comment, int id) {
        this.commentDao.createComment(comment, id);
    }

    @Override
    @Transactional
    public void removeComment(int id) {
        this.commentDao.removeComment(id);
    }

    @Override
    @Transactional
    public void editComment(Comment comment) {
        this.commentDao.editComment(comment);
    }

    @Override
    @Transactional
    public Comment getCommentById(int id) {
        return this.commentDao.getCommentById(id);
    }

    @Override
    @Transactional
    public List<Comment> getAllComments(Article article) {
        return this.commentDao.getAllComments(article);
    }
}