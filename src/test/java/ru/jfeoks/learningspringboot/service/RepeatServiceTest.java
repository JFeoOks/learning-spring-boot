package ru.jfeoks.learningspringboot.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RepeatServiceTest {

    @Test
    public void testStartRepeat() {
        RepeatService service = new RepeatService();

        service.add("id", Arrays.asList("Amigo", "Bravo"));
        Assert.assertEquals(Arrays.asList("Amigo", "Bravo"), service.get("id"));

        Assert.assertTrue(service.contains("id"));


        service.remove("id");
        Assert.assertNull(service.get("id"));
    }
}
