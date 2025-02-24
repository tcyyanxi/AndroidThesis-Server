package com.example.androidthesisserver.controller;

import com.example.androidthesisserver.service.UserWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-words")
public class UserWordsController {

    @Autowired
    private UserWordsService userWordsService;

    /**
     * 添加用户单词记录
     *
     * @param id 用户ID
     * @param words 单词列表
     * @return 成功或失败的响应
     */
    @PostMapping("/add")
    public String addUserWords(@RequestParam Long id, @RequestBody List<String> words) {
        try {
            userWordsService.addUserWords(id, words);
            return "User word records added successfully";
        } catch (Exception e) {
            return "Failed to add user word records: " + e.getMessage();
        }
    }

    /**
     * 获取用户已选单词
     *
     * @param id 用户ID
     * @return 已选单词列表
     */
    @GetMapping("/selected")
    public List<String> getWords(@RequestParam Long id) {
        try {
            return userWordsService.getWordsByUserId(id);
        } catch (Exception e) {
            return new ArrayList<>(); // 如果出错，返回空列表
        }
    }

    @PutMapping("/update")
    public String updateUserWord(@RequestParam Long id,
                                 @RequestParam String word,
                                 @RequestParam int count,
                                 @RequestParam String date) {
        // 直接更新数据
        userWordsService.updateUserWord(id, word, count, date);
        return "更新成功"; // 返回简单的字符串
    }
}
