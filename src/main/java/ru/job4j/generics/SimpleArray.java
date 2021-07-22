package ru.job4j.generics;

import java.util.Objects;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] arrList;
    private int currentSize;


    public SimpleArray(int length) {
        this.arrList = new Object[length];
    }

    public T get(int index) {
        Objects.checkIndex(index, currentSize);
        return (T) arrList[index];
    }


    public void set(int index, T element) {
        Objects.checkIndex(index, currentSize);
        arrList[index] = element;
    }

    public void add(T model) {
        if (currentSize == arrList.length) {
            throw new IndexOutOfBoundsException();
        }
        arrList[currentSize++] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, currentSize);
        System.arraycopy(arrList, index + 1, arrList, index, currentSize - index - 1);
        currentSize--;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize;
            }

            @Override
            public T next() {
                return (T) arrList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    public static void main(String[] args) {

    }
}




