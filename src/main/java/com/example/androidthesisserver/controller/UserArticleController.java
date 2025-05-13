package com.example.androidthesisserver.controller;

import com.example.androidthesisserver.entity.UserArticle;
import com.example.androidthesisserver.service.UserArticleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-article")
public class UserArticleController {

    @Resource
    private UserArticleService userArticleService;

    // 接收前端数据并插入数据库
    @PostMapping("/add")
    public String addUserArticle(@RequestBody UserArticle userArticle) {
        userArticleService.addUserArticle(userArticle);
        return "记录添加成功";
    }

    // 根据用户ID和文章ID查询
    @GetMapping("/get")
    public List<UserArticle> getUserArticle(@RequestParam Long id, @RequestParam Integer articleId) {
        return userArticleService.getUserArticle(id, articleId);
    }
}