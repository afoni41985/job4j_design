package ru.job4j.ood.lsp.example1;

public class Swan extends Bird {
    @Override
    public void eat() {
        System.out.println("OMG! I can eat pizza!");
    }

    @Override
    public void fly() {
        System.out.println("I believe I can fly!");
    }
}
