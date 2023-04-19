package ru.job4j.list;

public interface List<E> extends Iterable<E> {
    boolean add(E value);

    E get(int index);
}
