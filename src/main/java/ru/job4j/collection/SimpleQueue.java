package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        for (int i = 0; i < size; i++) {
            out.push(in.pop());
        }

        T rsl = out.pop();
        size--;
        for (int i = 0; i < size; i++) {
            in.push(out.pop());
        }

        return rsl;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}

