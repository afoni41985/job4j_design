package ru.job4j.io;

import java.io.*;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("even.txt"))) {
            for (String i = in.readLine(); i != null; i = in.readLine()) {
                System.out.println(
                        Integer.parseInt(i) % 2 == 0 ? i + " even" : i + " odd"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}