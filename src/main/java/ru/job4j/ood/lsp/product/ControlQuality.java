package ru.job4j.ood.lsp.product;


import ru.job4j.ood.lsp.product.model.Food;
import ru.job4j.ood.lsp.product.store.Store;

import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribution(Food food) {
       for (Store store : stores) {
           store.add(food);
       }
    }
}
