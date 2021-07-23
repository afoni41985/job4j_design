package ru.job4j.generics;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] data;
    private int size;


    public SimpleArray(int length) {
        this.data = new Object[length];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) data[index];
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        data[index] = element;
    }

    public void add(T model) {
        data[size++] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        data[index] = null;
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        size--;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[count++];
            }
        };
    }
}




