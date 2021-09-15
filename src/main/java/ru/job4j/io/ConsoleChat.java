package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> answers = readPhrases();
        Random random = new Random();
        int index;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String ask = reader.readLine();
            boolean isContinue = true;
            while (!ask.equals(OUT)) {
                index = random.nextInt(answers.size());
                if (ask.equals(STOP)) {
                    isContinue = false;
                }
                if (ask.equals(CONTINUE)) {
                    log.add(ask);
                    isContinue = true;
                    ask = reader.readLine();
                    continue;
                }
                if (isContinue) {
                    String answer = answers.get(index);
                    log.add(ask);
                    log.add(answer);
                    System.out.println(answer);
                } else {
                    log.add(ask);
                }
                ask = reader.readLine();
            }
            log.add(ask);
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (String string : log) {
                out.write(string);
                out.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("src/data/log.txt", "src/data/bot.txt");
        chat.run();

    }
}