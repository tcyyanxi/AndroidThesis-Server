package com.example.androidthesisserver.service;

import com.example.androidthesisserver.entity.Word;
import com.example.androidthesisserver.entity.WordDTO;
import com.example.androidthesisserver.mapper.WordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    private final WordMapper wordMapper;

    public WordService(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    public List<String> getAllBooks() {
        return wordMapper.getAllBooks();
    }

    public List<String> getUnitsByBook(String book) {
        return wordMapper.getUnitsByBook(book);
    }

    public List<Word> getWordsByBookAndUnit(String book, String unit) {
        return wordMapper.getWordsByBookAndUnit(book, unit);
    }

    public Word getAllByWord(String word){
        return wordMapper.getAllByWord(word);
    }

    public List<WordDTO> getWordsByUserIdAndDate(Long id, String date) {
        return wordMapper.getWordsByUserIdAndDate(id, date);
    }
}
