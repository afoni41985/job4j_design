package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        if (sources.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!target.exists()) {
            throw new IllegalArgumentException();
        }
        for (Path elem : sources) {
            packSingleFile(elem.toFile(), target);
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
    }
}