package ru.job4j.io;

import java.io.File;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException(
                    "Root folder is null or/and File extension not specified. "
                            + "Usage java -jar search.jar ROOT_FOLDER FILE_EXTENSION");
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.print(String.format("size : %s%n", file.getAbsoluteFile()));
        for (File sub : Objects.requireNonNull(file.listFiles())) {
            System.out.println(String.format("file : %s size : %s", sub.getName(), sub.length()));
        }
    }
}