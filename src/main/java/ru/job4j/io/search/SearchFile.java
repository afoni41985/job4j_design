package ru.job4j.io.search;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SearchFile {

    public static List<Path> searchByCriteria(ArgsName ar) throws IOException {
        List<Path> pathList;
        if (ar.get("t").equals("mask")) {
            pathList = Search.search(Path.of(ar.get("d")), p -> p.toFile().getName().endsWith(ar.get("n")));
        } else if (ar.get("t").equals("name")) {
            pathList = Search.search(Path.of(ar.get("d")), p -> p.toFile().getName().equals(ar.get("n")));
        } else {
            throw new IllegalArgumentException("Invalid search");
        }
        return pathList;
    }

    public static void write(List<Path> pathList, String file) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            pathList.forEach(path -> {
                printWriter.write(path.toFile().getName());
                printWriter.println(System.lineSeparator());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validArgs(String[] args) {
        ArgsName arg = ArgsName.of(args);
        if (args.length != 4) {
            throw new IllegalArgumentException("Incorrect parameters. "
                    + "-d directory to search,"
                    + "-n file name, mask,"
                    + "-t search type: mask search by mask, name by full name match,"
                    + "-o write the result to a file.");
        }
        if (!Files.exists(Path.of(arg.get("d"))) || !Files.isDirectory(Path.of(arg.get("d")))) {
            throw new IllegalArgumentException("Incorrect directory to search: "
                    + Path.of(arg.get("d")).toAbsolutePath());
        }
        if (arg.get("n") == null) {
            throw new IllegalArgumentException("No data to search file");
        }
        if (arg.get("t") == null) {
            throw new IllegalArgumentException("No search type");
        }
        if (arg.get("o") == null || Files.isDirectory(Path.of(arg.get("o")))) {
            throw new IllegalArgumentException("Wrong output");
        }
    }

    public static void main(String[] args) throws IOException {
        validArgs(args);
        ArgsName argsName = ArgsName.of(args);
        List<Path> pathList = searchByCriteria(argsName);
        write(pathList, argsName.get("o"));

    }
}
