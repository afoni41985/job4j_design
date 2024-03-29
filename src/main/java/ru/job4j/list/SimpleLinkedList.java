package ru.job4j.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> fstNode = null;
    private Node<E> root = null;
    private int size;
    private int modCount = 0;

    @Override
    public boolean add(E value) {
        if (root == null) {
            root = new Node<>(value, null);
            fstNode = root;
        } else {
            root.next = new Node<>(value, null);
            root = root.next;
            if (fstNode != null && fstNode.next == null) {
                fstNode.next = root;
            }
        }
        size++;
        modCount++;
        return false;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        int i = 0;
        Node<E> temp = fstNode;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = fstNode;
            private final int expectedMod = modCount;
            private final int count = 0;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedMod != modCount) {
                    throw new ConcurrentModificationException();
                }

               E rsl = current.item;
                current = current.next;
                return rsl;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
