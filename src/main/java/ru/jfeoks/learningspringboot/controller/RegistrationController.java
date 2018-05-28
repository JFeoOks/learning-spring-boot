package ru.jfeoks.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.jfeoks.learningspringboot.model.Role;
import ru.jfeoks.learningspringboot.model.User;
import ru.jfeoks.learningspringboot.repo.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User dbUser = userRepository.findByUsername(user.getUsername());

        if (dbUser != null) {
            model.put("message", "User exists!");
            return registration();
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
