package com.epam.training.newsportal.service;

import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.entity.Comment;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment, int id);
    void removeComment(int id);
    void editComment(Comment comment);
    Comment getCommentById(int id);
    List<Comment> getAllComments(Article article);
}