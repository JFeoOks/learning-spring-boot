package ru.jfeoks.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.jfeoks.learningspringboot.model.Word;
import ru.jfeoks.learningspringboot.repo.WordRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private WordRepository wordRepository;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("words", wordRepository.findAll());
        return "main";
    }

    @PostMapping
    public String addWord(@RequestParam String text, Map<String, Object> model) {
        wordRepository.save(new Word(text));
        model.put("words", wordRepository.findAll());

        return "main";
    }

    @GetMapping("/mix")
    public String mixWords(Map<String, Object> model) {
        List<Word> result = new ArrayList<>();
        wordRepository.findAll().forEach(result::add);

        Collections.shuffle(result);
        model.put("words", result);

        return "main";
    }

}
