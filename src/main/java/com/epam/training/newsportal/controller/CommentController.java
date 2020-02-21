package com.epam.training.newsportal.controller;

import com.epam.training.newsportal.dao.CommentDao;
import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.entity.Comment;
import com.epam.training.newsportal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class CommentController {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/comments/save")
    public String addComment(@ModelAttribute("comment") Comment comment, Article article) {
        System.out.println("addComment method starts");
        this.commentService.createComment(comment, article.getId());
        return "redirect:/articles";
    }
}