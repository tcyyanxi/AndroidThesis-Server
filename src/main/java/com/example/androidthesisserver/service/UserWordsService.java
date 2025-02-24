package com.example.androidthesisserver.service;

import com.example.androidthesisserver.entity.UserWords;
import com.example.androidthesisserver.mapper.UserWordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserWordsService {

    @Autowired
    private UserWordsMapper userWordsMapper;

    public void addUserWords(Long id, List<String> words) {
        for (String word : words) {
            UserWords userWords = new UserWords();
            userWords.setId(id);
            userWords.setWord(word);
            userWords.setDate(new Date());  // 设置当前日期

            // 使用 MyBatis 插入数据
            userWordsMapper.insert(userWords.getId(), userWords.getWord(), userWords.getDate());
        }
    }

    /**
     * 获取用户已选单词
     *
     * @param userId 用户ID
     * @return 用户已选单词列表
     */
    public List<String> getWordsByUserId(Long userId) {
        return userWordsMapper.getWordsByUserId(userId);
    }

    public void updateUserWord(Long id, String word, int count, String date) {
        userWordsMapper.updateUserWord(id, word, count, date);
    }
}

