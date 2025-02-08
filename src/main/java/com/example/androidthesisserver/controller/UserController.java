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
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

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
        } else {
            // 用户存在，直接登录
            userService.updateLoginStatus(email);
            response.put("status", "success");
            response.put("message", "登录成功");
        }

        return response;
    }

//    /**
//     * 测试数据库连接接口
//     * @return 返回测试结果的JSON
//     */
//    @GetMapping("/test")
//    public Map<String, Object> testDatabaseConnection() {
//        Map<String, Object> response = new HashMap<>();
//        try {
//            // 执行 SQL 查询，获取 uid 为 1 的 email
//            String sql = "SELECT email FROM thesis.users WHERE id = ?";
//            String email = jdbcTemplate.queryForObject(sql, new Object[]{1}, String.class);
//
//            // 判断是否找到了 email
//            if (email != null) {
//                response.put("status", "success");
//                response.put("message", "数据库连接成功！");
//                response.put("email", email);
//            } else {
//                response.put("status", "error");
//                response.put("message", "没有找到 uid 为 1 的用户！");
//            }
//        } catch (Exception e) {
//            response.put("status", "error");
//            response.put("message", "数据库连接失败！错误信息：" + e.getMessage());
//        }
//        return response;
//    }
        @GetMapping("/user")
    public User user(){
        User book = new User();
        book.setId(10086L);
        book.setEmail("罗贯中");
        book.setIsFirstLogin(true);
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        return book;
    }
}
