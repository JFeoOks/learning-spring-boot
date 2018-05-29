package ru.jfeoks.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.jfeoks.learningspringboot.model.Word;
import ru.jfeoks.learningspringboot.repo.WordRepository;

import java.util.Map;

@Controller
@RequestMapping("/repeat")
public class RepeatController {

    @Autowired
    private WordRepository wordRepository;

    @GetMapping
    public String repeat(Map<String, Object> model) {
        return "repeat";
    }

    @PostMapping
    public String addWord(String text, Map<String, Object> model) {
        Word foundedWord = wordRepository.findByText(text);

        if (foundedWord != null) model.put("words", foundedWord);

        return "repeat";
    }
}
