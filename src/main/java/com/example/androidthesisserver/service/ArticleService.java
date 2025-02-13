package com.example.androidthesisserver.service;


import com.example.androidthesisserver.entity.Article;
import com.example.androidthesisserver.entity.UserEdit;
import com.example.androidthesisserver.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getAllByCategory(String category) {
        return articleMapper.getAllByCategory(category);
    }

    public List<Article> getAllArticles(){
        return articleMapper.getAllArticles();
    }

}
