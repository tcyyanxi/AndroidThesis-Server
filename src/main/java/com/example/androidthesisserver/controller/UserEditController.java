package com.example.androidthesisserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.androidthesisserver.entity.UserEdit;
import com.example.androidthesisserver.service.UserEditService;
import com.example.androidthesisserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userEdit")
public class UserEditController {

    @Autowired
    private UserEditService userEditService;

    // 获取用户编辑信息
    @GetMapping("/{id}")
    public UserEdit getUserEdit(@PathVariable("id") Long userId) {
        return userEditService.getUserEditById(userId);
    }

    // 提交用户编辑信息
    @PostMapping("/submit")
    public Map<String, Object> submitUserEdit(@RequestBody UserEdit userEdit) {
        int result = userEditService.updateUserEdit(userEdit);
        return Map.of("status", result > 0 ? "success" : "failure");
    }

    // 删除用户编辑信息
    @DeleteMapping("/{userId}")
    public Map<String, Object> deleteUserEdit(@PathVariable("userId") Long userId) {
        int result = userEditService.deleteUserEdit(userId);
        return Map.of("status", result > 0 ? "success" : "failure");
    }
}