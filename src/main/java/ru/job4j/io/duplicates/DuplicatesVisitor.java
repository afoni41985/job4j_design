package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Set<FileProperty> files = new HashSet<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        var prop = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!files.add(prop)) {
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
