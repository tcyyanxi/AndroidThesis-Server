package com.example.androidthesisserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@TableName("user_article")
public class UserArticle {
    private Long id;           // 用户ID
    private Integer articleId; // 文章ID
    private Integer count;     // 访问次数
    private String time;    // 记录时间
}
