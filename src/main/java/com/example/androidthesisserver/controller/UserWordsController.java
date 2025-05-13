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
     * 添加用户单词记录（首次选词进入学习，count 为 0）
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

    /**
     * 用户提交单词学习成绩后，自动记录并生成下次复习计划（核心调度逻辑）
     */
    @PutMapping("/review/schedule")
    public String reviewAndSchedule(@RequestParam Long id,
                                    @RequestParam String word,
                                    @RequestParam int score,
                                    @RequestParam String date) {
        userWordsService.reviewAndSchedule(id, word, score, date);
        return "成绩已记录，系统已生成下次复习任务。";
    }
    @PutMapping("/reschedule/unfinished")
    public String rescheduleUnfinishedTasks(@RequestParam Long id) {
        int count = userWordsService.rescheduleUnfinishedWords(id);
        return "已顺延 " + count + " 条未完成计划到今天。";
    }

}
