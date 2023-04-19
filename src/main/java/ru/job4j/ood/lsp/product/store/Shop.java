package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;

public class Shop extends AbstractStore {
    @Override
    protected boolean checkFresh(Food food) {
        boolean rsl = false;
        if (food.getExpirePercent() > minExpiration && food.getExpirePercent() < maxExpiration) {
            rsl = true;
        } else if (food.getExpirePercent() > maxExpiration && food.getExpirePercent() < expiredExpiration) {
            food.setPrice(food.getPriceWithDiscount());
            rsl = true;
        }

        return rsl;
    }
}
