package ru.jfeoks.learningspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import ru.jfeoks.learningspringboot.model.Chapter;
import ru.jfeoks.learningspringboot.repo.ChapterRepository;

@Configuration
public class LoadDatabase {

    @Bean
    public CommandLineRunner init(ChapterRepository repository) {
        return args -> Flux.just(
          new Chapter("Quick Start with Java"),
          new Chapter("Reactive Web with Spring Boot"),
          new Chapter("...and more!"))
        .flatMap(repository::save)
        .subscribe(System.out::println);
    }
}
