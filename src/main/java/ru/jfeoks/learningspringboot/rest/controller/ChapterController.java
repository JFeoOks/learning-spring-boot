package ru.jfeoks.learningspringboot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.jfeoks.learningspringboot.model.Chapter;
import ru.jfeoks.learningspringboot.repo.ChapterRepository;

@RestController
public class ChapterController {

    private final ChapterRepository repository;

    public ChapterController(ChapterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/chapters")
    public Flux<Chapter> listing() {
        return repository.findAll();
    }
}
