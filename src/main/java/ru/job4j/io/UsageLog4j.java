package ru.job4j.io;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        boolean valid = true;
        float weight = 80.0f;
        char gender = 'm';
        short worker = 10;
        long height = 190L;
        double salary = 12345.6789;
        byte child = 1;
        LOG.debug("User info name : {}, age {}, valid {}, weight {}, gender {}, worker {}, height {}, salary {}, child {}",
                name, age, valid, weight, gender, worker, height, salary, child);

    }
}
