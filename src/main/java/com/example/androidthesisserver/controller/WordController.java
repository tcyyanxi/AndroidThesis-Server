package com.example.androidthesisserver.controller;

import com.example.androidthesisserver.entity.Word;
import com.example.androidthesisserver.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/books")
    public List<String> getAllBooks() {
        return wordService.getAllBooks();
    }

    @GetMapping("/units")
    public List<String> getUnitsByBook(@RequestParam String book) {
        return wordService.getUnitsByBook(book);
    }

    @GetMapping("/list")
    public List<Word> getWordsByBookAndUnit(@RequestParam String book, @RequestParam String unit) {
        return wordService.getWordsByBookAndUnit(book, unit);
    }

    @GetMapping("/word")
    public Word getAllByWord(@RequestParam String word){
        return  wordService.getAllByWord(word);
    }
}
