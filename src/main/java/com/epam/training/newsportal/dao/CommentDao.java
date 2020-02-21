package com.epam.training.newsportal.dao;

import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.entity.Comment;

import java.util.List;

public interface CommentDao {
    void createComment(Comment comment, int id);
    void removeComment(int id);
    void editComment(Comment comment);
    Comment getCommentById(int id);
    List<Comment> getAllComments(Article article);
}