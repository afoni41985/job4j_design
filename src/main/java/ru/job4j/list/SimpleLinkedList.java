package ru.job4j.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> fstNode = null;
    private Node<E> root = null;
    private int size;
    private int modCount = 0;

    @Override
    public void add(E value) {
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
        return new Iterator<E>() {
            private int expectedMod = modCount;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedMod != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (count == 0) {
                    root = fstNode;
                }
                Node<E> tmp = root;
                root = tmp.next;
                count++;
                return tmp.item;
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
