package ru.jfeoks.learningspringboot.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RepeatService {

    private ConcurrentHashMap<String, Collection<String>> startedRepeats = new ConcurrentHashMap<>();

    public void add(String id, Collection<String> words) {
        startedRepeats.put(id, words);
    }

    public Collection<String> get(String id) {
        return startedRepeats.get(id);
    }

    public void remove(String id) {
        startedRepeats.remove(id);
    }

    public boolean contains(String id) {
        return startedRepeats.containsKey(id);
    }
}
