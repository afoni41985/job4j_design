package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;

public class Warehouse extends AbstractStore {

    @Override
    protected boolean checkFresh(Food food) {

        return food.getExpirePercent() < minExpiration;
    }
}
