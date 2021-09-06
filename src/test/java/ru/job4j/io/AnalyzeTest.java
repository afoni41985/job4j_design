package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    @Test
    public void whenTwoRangeUnavailable() {
        String source = "./project/server.log";
        String target = "./project/unavailable.csv";
        Analyze analyze = new Analyze();
        analyze.unavailable(source, target);
        try (var in = new BufferedReader(new FileReader(target))) {
            assertThat(in.readLine(), is("10:57:01;10:59:01;"));
            assertThat(in.readLine(), is("11:01:02;11:02:02;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}