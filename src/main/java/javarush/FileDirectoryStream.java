package javarush;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

public class FileDirectoryStream {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path directory = Path.of(scanner.nextLine());
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path line : directoryStream) {
                if (Files.isRegularFile(line)) {
                    System.out.println(line.toAbsolutePath() + THIS_IS_FILE);
                } else if (Files.isDirectory(line)) {
                    System.out.println(line.toAbsolutePath() + THIS_IS_DIR);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

