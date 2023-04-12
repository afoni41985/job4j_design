package ru.job4j.ood.isp.example2;

import java.util.List;

/***
 * В интерфейсе больше трех методов, что я вляется нарушением
 * необходимо разделить на несколько.
 */
public interface Programs {
    String name();

    int price();

    List<Integer> number();

    String lag();

    String monitor();
}
