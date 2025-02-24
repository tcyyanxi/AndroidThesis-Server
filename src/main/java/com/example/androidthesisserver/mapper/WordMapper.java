package com.example.androidthesisserver.mapper;

import com.example.androidthesisserver.entity.Word;
import com.example.androidthesisserver.entity.WordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordMapper {

    @Select("SELECT DISTINCT book FROM words")
    List<String> getAllBooks();

    @Select("SELECT DISTINCT unit FROM words WHERE book = #{book}")
    List<String> getUnitsByBook(String book);

    @Select("SELECT * FROM words WHERE book = #{book} AND unit = #{unit}")
    List<Word> getWordsByBookAndUnit(String book, String unit);

    @Select("SELECT * FROM words WHERE word = #{word}")
    Word getAllByWord(String word);

    @Select("SELECT w.word, w.pro, w.mean " +
            "FROM user_words uw " +
            "JOIN words w ON uw.word = w.word " +
            "WHERE uw.id = #{id} AND uw.date = #{date} AND uw.count = 0")
    List<WordDTO> getWordsByUserIdAndDate(@Param("id") Long id, @Param("date") String date);


}
