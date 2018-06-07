package ru.jfeoks.learningspringboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ru.jfeoks.learningspringboot.model.History;
import ru.jfeoks.learningspringboot.repo.HistoryRepository;
import ru.jfeoks.learningspringboot.repo.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RepeatService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryRepository historyRepository;

    private Collection<String> allWords;
    private Collection<String> wordsUppercase;
    private Collection<String> remindedWords = new HashSet<>();
    private String userName;

    private ObjectMapper jsonMapper = new ObjectMapper();

    public void start(Collection<String> words, String userName) {
        this.allWords = words;
        this.userName = userName;

        wordsUppercase =
                allWords
                        .stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toSet());
    }

    public Collection<String> getAllWords() {
        return allWords;
    }

    public boolean check(String word) {
        boolean result = wordsUppercase.contains(word.toUpperCase());
        if (result) remindedWords.add(word);

        return result;
    }

    public Collection<String> getRemindedWords() {
        return remindedWords;
    }

    public void stop() {
        save();
        clear();
    }

    private void save() {
        ObjectNode result = jsonMapper.createObjectNode();
        result.set("allWords", jsonMapper.valueToTree(allWords));
        result.set("remindedWords", jsonMapper.valueToTree(remindedWords));

        History history = new History();
        history.setHistory(result.textValue());
        history.setUser(userRepository.findByUsername(userName));

        historyRepository.save(history);
    }

    private void clear() {
        allWords = null;
        wordsUppercase = null;
        remindedWords = new HashSet<>();
    }
}
