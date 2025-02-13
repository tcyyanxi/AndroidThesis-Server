package com.example.androidthesisserver.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("article")
@Data
public class Article {
    @TableId(value = "article_id", type = IdType.AUTO)
    private int articleId;
    private String title;
    private String content;
    private int articlesSum;
    private String category;
}
