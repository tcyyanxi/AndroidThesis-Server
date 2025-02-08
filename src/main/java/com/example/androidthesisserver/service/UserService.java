package com.example.androidthesisserver.service;

import com.example.androidthesisserver.entity.User;
import com.example.androidthesisserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据邮箱查找用户
     * @param email 用户邮箱
     * @return 用户对象，如果没有找到，返回null
     */
    public User findUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    /**
     * 注册用户
     * @param email 用户邮箱
     */
    public void registerUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setIsFirstLogin(true);  // 表示是第一次登录
        userMapper.insertUser(user);
    }

    /**
     * 更新用户登录状态
     * @param email 用户邮箱
     */
    public void updateLoginStatus(String email) {
        userMapper.updateLoginStatus(email);
    }
}