package ru.jfeoks.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.jfeoks.learningspringboot.repo.WordRepository;
import ru.jfeoks.learningspringboot.service.RepeatService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/repeat")
public class RepeatController {

    @Autowired
    RepeatService repeatService;

    @PostMapping
    public String repeat(@RequestBody List<String> words, Principal principal, Map<String, Object> model) {
        repeatService.add(principal.getName(), words);
        return "repeat";
    }

    @GetMapping("/check")
    @ResponseBody
    public Boolean checkWords(@RequestParam("word") String word, Principal principal) {
        Collection<String> words = repeatService.get(principal.getName());
        if (words == null) throw new IllegalArgumentException("Repeat is not started!");

        return words.contains(word);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSession(Principal principal) {
        repeatService.remove(principal.getName());
    }
}
