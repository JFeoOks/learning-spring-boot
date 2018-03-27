package ru.jfeoks.learningspringboot.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.jfeoks.learningspringboot.model.Chapter;

public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> {
}
