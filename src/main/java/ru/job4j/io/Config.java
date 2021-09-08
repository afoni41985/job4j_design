package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String str = read.readLine(); str != null; str = read.readLine()) {
                if (str.isBlank() || str.startsWith("#")) {
                    continue;
                }
                String[] rsl = str.split("=");
                if (rsl.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(rsl[0], rsl[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
     return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}