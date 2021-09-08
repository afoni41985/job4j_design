package ru.job4j.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("The root folder and the file extension is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Path.of(args[0]);
        search(start, p -> p.toFile().getName().endsWith("txt")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        List<Path> list = new ArrayList<>();
        try (DirectoryStream<Path> files = Files.newDirectoryStream(root)) {
            for (Path path : files) {
                if (condition.test(path)) {
                    list.add(path);
                }
            }
        }
        return list;
    }
}