package com.example.androidthesisserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_edit")
public class UserEdit {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    private String avatar;
    private String username;
    private String gender;
    private Date birthday;
    public UserEdit() {
        this.id = id;
        this.avatar = null; // 默认头像
        this.username = "user" + System.currentTimeMillis(); // 生成唯一用户名
        this.gender = "保密";
        this.birthday = null;
    }
}