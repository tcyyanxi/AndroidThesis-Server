package com.example.androidthesisserver.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Base64;

@TableName("article")
public class Article {
    @TableId(value = "article_id", type = IdType.AUTO)
    private int articleId;
    private String title;
    private String content;
    private int articlesSum;
    private String category;

    @JsonIgnore  // 让 `img` 不直接序列化成 JSON 数组
    private byte[] img;

    @JsonProperty("img")  // 让 `img` 以 Base64 字符串形式返回
    public String getImgBase64() {
        return (img != null) ? Base64.getEncoder().encodeToString(img) : null;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getArticlesSum() {
        return articlesSum;
    }

    public void setArticlesSum(int articlesSum) {
        this.articlesSum = articlesSum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}