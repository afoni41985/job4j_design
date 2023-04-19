package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public abstract class AbstractStore implements Store {

    private final List<Food> foods = new ArrayList<>();

    protected final int  minExpiration = 25;
    protected final int  maxExpiration = 75;
    protected final int  expiredExpiration = 100;
    abstract protected boolean checkFresh(Food food);

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (checkFresh(food)) {
            foods.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getStore() {
        return foods;
    }

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return foods
                .stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}