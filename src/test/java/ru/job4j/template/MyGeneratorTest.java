package ru.job4j.template;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

class MyGeneratorTest {
    Generator generator = new MyGenerator();
    Map<String, String> map = new HashMap<>();
    String template = "I am a ${name}, Who are ${subject}?";

    @Disabled
    @Test
    public void whenTheTemplateHasAllTheKeys() {
        map.put("name", "Pavel");
        map.put("subject", "Petrov");
        assertEquals("I am a Pavel, Who are Petrov?", generator.produce(template, map));
    }


    @Disabled
    @Test
    public void whenKeysThatAreNotInTheMap() {
        map.put("subject", "Petrov");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, map);
        });
    }

    @Disabled
    @Test
    public void whenAreExtraKeysInTheMap() {
        map.put("age", "10");
        map.put("gender", "Man");
        map.put("name", "Pavel");
        map.put("subject", "Petrov");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, map);
        });
    }
}