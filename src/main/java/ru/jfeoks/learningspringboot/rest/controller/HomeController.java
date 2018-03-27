package ru.jfeoks.learningspringboot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String greeings(@RequestParam(required = false, defaultValue = "") String name) {
        return name.isEmpty() ? "Hey!" : "Hey, " + name + "!";
    }
}
