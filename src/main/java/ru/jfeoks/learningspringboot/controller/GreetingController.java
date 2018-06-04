package ru.jfeoks.learningspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(Principal principal, Map<String, Object> model) {
        model.put("username", principal.getName());
        return "greeting";
    }
}
