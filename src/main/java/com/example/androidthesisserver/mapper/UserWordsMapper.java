package com.example.androidthesisserver.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserWordsMapper {
    @Insert("INSERT INTO user_words (id, word, count, date) " +
            "VALUES (#{id}, #{word}, 0, #{date})")  // count 设置为 null
    void insert(@Param("id") Long id,
                @Param("word") String word,
                @Param("date") Date date);
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

    

}
