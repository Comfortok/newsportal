package com.epam.training.newsportal.controller;

import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    @Qualifier(value = "articleService")
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String listArticles(Model model) {
            model.addAttribute("article", new Article());
            model.addAttribute("listArticles", this.articleService.getAllArticles());
            return "articles";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addArticle(@ModelAttribute("article") Article article) {
        this.articleService.createArticle(article);
        return "redirect:/articles";
    }

    @RequestMapping("/add")
    public String newArticleForm(@ModelAttribute("article") Article article, Model model) {
        if (article.getId() != 0) {
            model.addAttribute(article);
        }
        return "addForm";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeArticle(@PathVariable("id") int id) {
        this.articleService.removeArticle(id);
        return "redirect:/articles";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editArticle(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", this.articleService.getArticleById(id));
        model.addAttribute("listArticles", this.articleService.getAllArticles());
        return "articles";
    }

    @RequestMapping("articleInfo/{id}")
    public String articleInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", this.articleService.getArticleById(id));
        return "articleInfo";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String remove(HttpServletRequest request, ModelMap modelMap) {
        String[] articleId = request.getParameterValues("articleId");
        if (articleId != null) {
            for (String id : articleId) {
                this.articleService.removeArticle(Integer.parseInt(id));
            }
        } else {
            modelMap.put("error", "error in remove method");
        }
        return "redirect:/articles";
    }
}