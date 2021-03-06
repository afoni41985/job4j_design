package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
it.next() - возвращают только четные числа. В этом примере - это 4 и 2.
it.hasNext() - возвращает true, только если в массиве есть четные перед указателем.
 */
public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int row = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        while (row < data.length) {
            if (data[row] % 2 == 0) {
                rsl = true;
                break;
            }
            row++;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row++];
    }
}