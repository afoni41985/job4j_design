package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(sources.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Invalid arguments "
                    + "Usage java "
                    + "-jar pack.jar -d=DIRECTORY_ARCHIVE -e=EXCLUDE_EXCLUDE -o=OUTPUT_ARCHIVE");
        }
        ArgsName argsName = ArgsName.of(args);
        Path root = Path.of(argsName.get("d"));
        if (!Files.exists(root)) {
            throw new IllegalArgumentException("folder does not exist");
        }
        String extent = argsName.get("e");
        File target = new File(argsName.get("o"));
        List<Path> sources = Search.search(root, path ->
                !path.toFile().getName().endsWith(extent));
        packFiles(sources, target);

    }
}