package javarush;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Scanner;

public class Output {
    public static void main(String[] args)  {
        byte[] bytes = args[0].getBytes();
        try (InputStream stream = System.in;
             Scanner scanner = new Scanner(stream)) {
            for (int i = 0; i < bytes.length; i++) {
                Files.write(Path.of(scanner.nextLine()), args[i].getBytes());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
