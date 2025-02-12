package com.example.androidthesisserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("users")  // 表明该实体类对应的表
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String email;
    private Boolean isFirstLogin;
    private Date createTime;
    private Date updateTime;


}