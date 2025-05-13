package com.example.androidthesisserver.service;

import com.example.androidthesisserver.entity.UserArticle;
import com.example.androidthesisserver.mapper.UserArticleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserArticleService {

    @Resource
    private UserArticleMapper userArticleMapper;

    // 插入记录
    public void addUserArticle(UserArticle userArticle) {
        userArticleMapper.insertUserArticle(userArticle);
    }

    // 获取特定记录
    public List<UserArticle> getUserArticle(Long id, Integer articleId) {
        return userArticleMapper.getUserArticle(id, articleId);
    }


}