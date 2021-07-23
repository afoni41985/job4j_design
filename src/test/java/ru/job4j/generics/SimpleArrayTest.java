package ru.job4j.generics;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Iterator;

public class SimpleArrayTest {

    @Test
    public void whenAddAndGet() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(100);
        assertThat(sa.get(0), is(100));
    }

    @Test
    public void whenAddAndSet() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(100);
        sa.set(0, 200);
        assertThat(sa.get(0), is(200));
    }

    @Test
    public void whenAddAndRemove() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(100);
        sa.add(200);
        sa.remove(0);
        assertThat(sa.get(0), is(200));
    }

    @Test
    public void whenCallIteratorThenMultiCallNextAndHasNext() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(100);
        sa.add(200);
        Iterator<Integer> it = sa.iterator();
        assertThat(it.next(), is(100));
        assertThat(it.next(), is(200));
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }
}