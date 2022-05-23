package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.putIfAbsent(key, new SoftReference<>(value));
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            cache.put(key, new SoftReference<V>(null));
        }
        V strong = cache.get(key).get();
        if (strong == null) {
            strong = load(key);
            put(key, strong);
        }
        return strong;

    }

    protected abstract V load(K key);

}