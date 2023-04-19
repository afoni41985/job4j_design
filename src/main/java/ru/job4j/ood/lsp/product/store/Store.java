package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    boolean add(Food food);

    List<Food> getStore();

    List<Food> findBy(Predicate<Food> filter);
}
