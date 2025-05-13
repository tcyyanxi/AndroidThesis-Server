package com.example.androidthesisserver.mapper;

import com.example.androidthesisserver.entity.UserArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserArticleMapper {

    // 插入数据
    @Insert("INSERT INTO user_article (id, article_id, count, time) VALUES (#{id}, #{articleId}, #{count}, #{time})")
    void insertUserArticle(UserArticle userArticle);

    // 查询特定用户和文章的记录
    @Select("SELECT * FROM user_article WHERE id = #{id} AND article_id = #{articleId}")
    List<UserArticle> getUserArticle(@Param("id") Long id, @Param("articleId") Integer articleId);
}
