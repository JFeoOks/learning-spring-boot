package ru.jfeoks.learningspringboot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.jfeoks.learningspringboot.model.Word;

public interface WordRepository extends CrudRepository<Word, Long> {

    Word findByText(String text);
}
