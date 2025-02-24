package com.example.androidthesisserver.mapper;


import com.example.androidthesisserver.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT article_id, title, content, word_sum AS articlesSum, category,img FROM article WHERE category = #{category}")
    List<Article> getAllByCategory(@Param("category") String category);

    @Select("SELECT article_id, title, content, word_sum AS articlesSum, category,img FROM article")
    List<Article> getAllArticles();
}
