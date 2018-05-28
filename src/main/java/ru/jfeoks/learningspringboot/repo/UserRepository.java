package ru.jfeoks.learningspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jfeoks.learningspringboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
