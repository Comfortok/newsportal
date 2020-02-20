package com.epam.training.newsportal.controller;

import com.epam.training.newsportal.entity.Article;
import com.epam.training.newsportal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String listArticles(Model model, Locale locale) {
        model.addAttribute("article", new Article());
        model.addAttribute("listArticles", this.articleService.getAllArticles());
        return "articles";
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "releaseDate", new CustomDateEditor(dateFormat, true));
    }

    @PostMapping(value = "/articles/save")
    public String addArticle(@Valid @ModelAttribute("article") Article article, Errors errors) {
        if (errors.hasErrors()) {
            return "addForm";
        }
        System.out.println("addArticle method starts");
        if (article.getId() == 0) {
            System.out.println("addArticle.id=0");
            this.articleService.createArticle(article);
        } else {
            System.out.println("addArticle.id!=0");
            this.articleService.editArticle(article);
        }
        return "redirect:/articles";
    }

    @RequestMapping("/add")
    public String newArticleForm(@ModelAttribute("article") Article article, Model model) {
        System.out.println(article.getId() + " -- id");
        model.addAttribute(article);
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
        return "addForm";
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