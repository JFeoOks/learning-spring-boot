package ru.jfeoks.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.jfeoks.learningspringboot.exception.EmptyWordsException;
import ru.jfeoks.learningspringboot.service.RepeatService;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/repeat")
public class RepeatController {

    @Autowired
    RepeatService repeatService;

    @PostMapping
    public String repeat(@RequestBody List<String> words, Principal principal, Map<String, Object> model) {
        if (words.isEmpty()) throw new EmptyWordsException();
        else repeatService.start(words, principal.getName());

        return "repeat";
    }

    @GetMapping("/check")
    @ResponseBody
    public Boolean checkWords(@RequestParam("word") String word) {
        return repeatService.check(word);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSession() {
        repeatService.stop();
    }
}
