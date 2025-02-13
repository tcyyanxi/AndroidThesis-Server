package com.example.androidthesisserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("words")
public class Word {
    private Long wordId;
    private String book;
    private String unit;
    private String word;
    private String pro;
    private String mean;
}
