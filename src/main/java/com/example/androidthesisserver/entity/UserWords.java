package com.example.androidthesisserver.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_words")
public class UserWords {

    private Long id;
    private String word;
    private int count;
    private Date date;
    private Integer intervalDays;
}
