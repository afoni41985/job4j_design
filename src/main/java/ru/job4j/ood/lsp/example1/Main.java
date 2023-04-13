package ru.job4j.ood.lsp.example1;

import java.util.ArrayList;
import java.util.List;

/**
 *Как только был расширен класс Bird новым типом
 * птиц Penguin, который не умеет летать. При запуске
 * выдает исключение UnsupportedOperationException("Help! I cannot fly!").
 * код нарушает принцип подстановки Лисков, поскольку у класса Bird есть
 * дочерний элемент, который неправильно использовал наследование и,
 * следовательно, вызвал проблему. Пингвин пытается расширить логику полета,
 * но он не умеет летать.
 */
public class Main {
    public static void letBirdsFly(List<Bird> birds) {
        for (Bird bird : birds) {
            bird.fly();
        }
    }

    public static void main(String[] args) {
        List<Bird> birds = new ArrayList<>();
        birds.add(new Swan());
        birds.add(new Penguin());
        letBirdsFly(birds);
    }
}


