package com.example.androidthesisserver.controller;


import com.example.androidthesisserver.entity.Article;
import com.example.androidthesisserver.entity.Word;
import com.example.androidthesisserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public List<Article> getAllByCategory(@RequestParam String category){
        return  articleService.getAllByCategory(category);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return  articleService.getAllArticles();
    }

}
