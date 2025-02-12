package com.example.androidthesisserver.controller;

import com.example.androidthesisserver.entity.User;
import com.example.androidthesisserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/tancy")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 用户登录接口
     * 根据邮箱判断用户是否注册，如果未注册则进行注册，已注册则直接登录
     * @param email 用户的邮箱
     * @return 返回登录或注册状态
     */
    @PostMapping("/user/login")
    public Map<String, Object> login(@RequestParam("email") String email) {
        Map<String, Object> response = new HashMap<>();

        // 检查该邮箱是否已经注册
        User user = userService.findUserByEmail(email);

        if (user == null) {
            // 邮箱未注册，进行注册
            userService.registerUser(email);
            response.put("status", "first_login");
            response.put("message", "用户注册成功");
            response.put("id",user.getId());
        } else {
            // 用户存在，直接登录
            userService.updateLoginStatus(email);
            response.put("status", "success");
            response.put("message", "登录成功");
            response.put("id",user.getId());
        }

        return response;
    }
}
