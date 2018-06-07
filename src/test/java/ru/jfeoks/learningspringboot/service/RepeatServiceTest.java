package ru.jfeoks.learningspringboot.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RepeatServiceTest {

    @Test
    public void testRepeat() {
        RepeatService service = new RepeatService();

        service.start(Arrays.asList("Amigo", "Bravo"), "a");

        Assert.assertTrue(service.check("Amigo"));
        Assert.assertFalse(service.check("Delta"));
        Assert.assertEquals(Arrays.asList("Amigo", "Bravo"), service.getAllWords());
        Assert.assertEquals(new HashSet<>(Collections.singletonList("Amigo")), service.getRemindedWords());
    }
}
