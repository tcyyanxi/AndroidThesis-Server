package com.example.androidthesisserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("users")  // 表明该实体类对应的表
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String email;
    private Boolean isFirstLogin;
    private Date createTime;
    private Date updateTime;

    // Getter and Setter 方法

    public Long getId() {
        return id;
    }

    public void setId(Long uid) {
        this.id = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(Boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}