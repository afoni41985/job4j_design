package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Analyze {


    public void unavailable(String source, String target) {
        int crash = 400;
        try (var in = new BufferedReader(new FileReader(source));
             var out = new PrintWriter(new FileWriter(target))) {
            String line;
            var startIsFound = false;
            while ((line = in.readLine()) != null) {
                String[] words = line.split(" ");
                if (!startIsFound) {
                    if (Integer.parseInt(words[0]) >= crash) {
                        out.printf("%s;", words[1]);
                        startIsFound = true;
                    }
                } else  if (Integer.parseInt(words[0]) < crash) {
                    out.printf("%s;%n", words[1]);
                    startIsFound = false;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analyze analyze = new Analyze();
        analyze.unavailable("server.log", "unavailable.csv");
    }
}