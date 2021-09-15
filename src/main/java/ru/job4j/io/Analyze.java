package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Analyze {


    public void unavailable(String source, String target) {
        int crash = 400;
        try (var in = new BufferedReader(new FileReader(source));
             var out = new PrintWriter(new FileWriter(target))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                String[] words = line.split(" ");
                if (sb.length() == 0 && Integer.parseInt(words[0]) >= crash) {
                    sb.append(words[1]).append(";");
                }
                if (sb.length() > 0 && Integer.parseInt(words[0]) < crash) {
                    sb.append(words[1]).append(";");
                    out.println(sb);
                    sb = new StringBuilder();
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