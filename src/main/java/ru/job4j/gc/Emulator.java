package ru.job4j.gc;

import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {
        System.out.println("Введите абсолютный путь до файла");
        String directory = new Scanner(System.in).nextLine();
        System.out.println("Введите полное имя файла");
        String fileName = new Scanner(System.in).nextLine();
        AbstractCache<String, String> cache = new DirFileCache(directory);
        cache.put(fileName, cache.load(fileName));
        System.out.println("Содержимое файла из кэша");
        System.out.println(cache.get("Names.txt"));

    }
}