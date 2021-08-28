package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int row = 0; row < 9; row++) {
                for (int cell = 0; cell < 9; cell++) {
                    int n = (row + 1) * (cell + 1);
                    out.write((n + " ").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

