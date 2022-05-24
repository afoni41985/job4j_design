package ru.job4j.gc;

import java.io.IOException;
import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        try {
            showMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showMenu() throws IOException {
        System.out.println("Укажите кэшируемую директорию :");
        String directory = new Scanner(System.in).nextLine();
        AbstractCache<String, String> cache = new DirFileCache(directory);
        char choice, ignore;
        String fileNameRead, fileNameRead2;
        do {
            System.out.println("1 Загрузка содержимого в кэш "
                    + System.lineSeparator() + "2 Чтение содержимое кэша"
                    + System.lineSeparator() + "q Выход");
            choice = (char) System.in.read();
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');
        } while (choice < '1' | choice > '2' & choice != 'q');

        System.out.println("\n");

        switch (choice) {
            case '1':
                System.out.println("Введите полное имя файла");
                fileNameRead = new Scanner(System.in).nextLine();
                cache.put(fileNameRead, cache.load(fileNameRead));
                System.out.println("Данные успешно загружены");
              break;
            case '2':
                System.out.println("Введите полное имя файла");
                 fileNameRead2 = new Scanner(System.in).nextLine();
                System.out.println(cache.get(fileNameRead2));
                break;
            case 'q':
                break;
            default:
                System.out.println("Ты все испортил");

        }
    }
}
