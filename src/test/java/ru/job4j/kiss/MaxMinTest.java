package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {
    List<String> strings = List.of("A", "B", "C", "D", "F");
    List<Integer> integers = List.of(1, 2, 3, 4, 5);
    Comparator<Integer> integerComparator = Integer::compareTo;
    Comparator<String> stringComparator = String::compareTo;


    @Test
    void whenMaximumInteger() {
        Integer result = new MaxMin().maximum(integers, integerComparator);
        Integer expected = 5;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMinimumInteger() {
        Integer result = new MaxMin().minimum(integers, integerComparator);
        Integer expected = 1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMaximumString() {
        String result = new MaxMin().maximum(strings, stringComparator);
        String expected = "F";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMinimumString() {
        String result = new MaxMin().minimum(strings, stringComparator);
        String expected = "A";
        assertThat(result).isEqualTo(expected);
    }
}