package com.epam.training.newsportal.controller;

import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    @Qualifier(value = "articleService")
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public String listArticles(Model model) {
            model.addAttribute("article", new Article());
            model.addAttribute("listArticles", this.articleService.getAllArticles());
            return "articles";
    }

    @RequestMapping(value = "/articles/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("article") Article article){
        if(article.getId() == 0){
            this.articleService.createArticle(article);
        }else {
            this.articleService.editArticle(article);
        }

        return "redirect:/articles";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeArticle(@PathVariable("id") int id) {
        this.articleService.removeArticle(id);

        return "redirect:/articles";
    }

    @RequestMapping(value = "edit/{id}")
    public String editArticle(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", this.articleService.getArticleById(id));
        model.addAttribute("listArticles", this.articleService.getAllArticles());
        return "articles";
    }

    @RequestMapping(value = "article/{id}")
    public String articleInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", this.articleService.getArticleById(id));
        return "articleinfo";
    }
}