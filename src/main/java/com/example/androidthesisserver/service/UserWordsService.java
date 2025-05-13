package com.example.androidthesisserver.service;

import com.example.androidthesisserver.entity.UserWords;
import com.example.androidthesisserver.mapper.UserWordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class UserWordsService {

    @Autowired
    private UserWordsMapper userWordsMapper;

//    public void addUserWords(Long id, List<String> words) {
//        for (String word : words) {
//            UserWords userWords = new UserWords();
//            userWords.setId(id);
//            userWords.setWord(word);
//            userWords.setDate(new Date());  // 设置当前日期
//
//            // 使用 MyBatis 插入数据
//            userWordsMapper.insert(userWords.getId(), userWords.getWord(), userWords.getDate());
//        }
//    }
public void addUserWords(Long id, List<String> words) {
    for (String word : words) {
        UserWords uw = new UserWords();
        uw.setId(id);
        uw.setWord(word);
        uw.setCount(0);  // 表示尚未评分（或系统计划）
        Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        uw.setDate(today);
        uw.setIntervalDays(null);
        userWordsMapper.insertUserWords(uw);
    }
}

    public List<String> getWordsByUserId(Long userId) {
        return userWordsMapper.getWordsByUserId(userId);
    }

    public void updateUserWord(Long id, String word, int count, String dateStr) {
        userWordsMapper.updateUserWord(id, word, count, dateStr);
    }

    public void reviewAndSchedule(Long userId, String word, int score, String currentDateStr) {
        LocalDate currentDate = LocalDate.parse(currentDateStr);

        UserWords current = new UserWords();
        current.setId(userId);
        current.setWord(word);
        current.setCount(score);
        current.setDate(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        UserWords last = userWordsMapper.findLatestByUserAndWord(userId, word);
        int lastInterval = (last != null && last.getIntervalDays() != null) ? last.getIntervalDays() : 1;

        int interval;
        if (score >= 90) {
            interval = lastInterval + 3;
        } else if (score >= 75) {
            interval = lastInterval + 2;
        } else if (score >= 60) {
            interval = 2;
        } else {
            interval = 1;
        }

        current.setIntervalDays(interval);
        userWordsMapper.insertUserWords(current);

        // 创建下一次复习任务
        LocalDate nextDate = currentDate.plusDays(interval);
        UserWords next = new UserWords();
        next.setId(userId);
        next.setWord(word);
        next.setCount(0);
        next.setDate(Date.from(nextDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        next.setIntervalDays(interval);
        userWordsMapper.insertUserWords(next);
    }

    public int rescheduleUnfinishedWords(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        String yesterdayStr = yesterday.toString();
        Date todayDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<UserWords> unfinished = userWordsMapper.findUnfinishedByUserAndDate(userId, yesterdayStr);
        int added = 0;

        for (UserWords word : unfinished) {
            UserWords copy = new UserWords();
            copy.setId(userId);
            copy.setWord(word.getWord());
            copy.setCount(0);  // 继续未完成
            copy.setDate(todayDate);
            copy.setIntervalDays(word.getIntervalDays());
            userWordsMapper.insertUserWords(copy);
            added++;
        }

        return added;
    }

}

