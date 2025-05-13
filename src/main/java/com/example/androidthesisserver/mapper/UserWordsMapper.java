package com.example.androidthesisserver.mapper;

import com.example.androidthesisserver.entity.UserWords;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserWordsMapper {
//    @Insert("INSERT INTO user_words (id, word, count, date) " +
//            "VALUES (#{id}, #{word}, 0, #{date})")  // count 设置为 null
//    void insert(@Param("id") Long id,
//                @Param("word") String word,
//                @Param("date") Date date);
// 插入完整记录（包括实际学习或系统生成的计划）
@Insert("INSERT INTO user_words (id, word, count, date, interval_days) " +
        "VALUES (#{id}, #{word}, #{count}, #{date}, #{intervalDays})")
int insertUserWords(UserWords userWords);


    // 通过用户ID查询所有单词
    @Select("SELECT word FROM user_words WHERE id = #{id}")
    List<String> getWordsByUserId(Long id);


    @Update("UPDATE user_words " +
            "SET count = #{count} " +
            "WHERE id = #{id} AND word = #{word} AND date = #{date}")
    int updateUserWord(@Param("id") Long id,
                       @Param("word") String word,
                       @Param("count") int count,
                       @Param("date") String date);

    @Select("SELECT * FROM user_words WHERE id = #{userId} AND word = #{word} ORDER BY date DESC LIMIT 1")
    UserWords findLatestByUserAndWord(@Param("userId") Long userId, @Param("word") String word);

    @Select("SELECT * FROM user_words " +
            "WHERE id = #{userId} AND date = #{date} AND count = 0")
    List<UserWords> findUnfinishedByUserAndDate(@Param("userId") Long userId,
                                                @Param("date") String date);


}
