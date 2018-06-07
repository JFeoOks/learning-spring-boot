package ru.jfeoks.learningspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jfeoks.learningspringboot.model.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
