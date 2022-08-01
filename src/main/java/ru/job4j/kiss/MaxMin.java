package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T maximum(List<T> value, Comparator<T> comparator) {
        return maxAndMin(value, comparator, m -> m < 0);
    }

    public <T> T minimum(List<T> value, Comparator<T> comparator) {
        return maxAndMin(value, comparator, m -> m > 0);
    }
    private <T> T maxAndMin(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T result = value.isEmpty() ? null : value.get(0);
        for (T t : value) {
            if (predicate.test(comparator.compare(result, t))) {
                result = t;
            }
        }
        return result;
    }
}