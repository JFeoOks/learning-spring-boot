package ru.jfeoks.learningspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Words is not selected")
public class EmptyWordsException extends RuntimeException {}
