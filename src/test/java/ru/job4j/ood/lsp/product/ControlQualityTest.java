package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.product.model.Food;
import ru.job4j.ood.lsp.product.store.Shop;
import ru.job4j.ood.lsp.product.store.Store;
import ru.job4j.ood.lsp.product.store.Trash;
import ru.job4j.ood.lsp.product.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    void whenStoreDistribution() {
        Food milk = new Food("агуша", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(5), 100, 0);
        Food cookie = new Food("печенька", LocalDate.now().minusDays(4),
                LocalDate.now().plusDays(5), 200, 0);
        Food milk1 = new Food("агуша", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(1), 50, 20);
        Food cookie1 = new Food("печенька", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(1), 200, 15);
        Food milk2 = new Food("агуша", LocalDate.now().minusDays(8),
                LocalDate.now().minusDays(2), 20, 0);
        Food milk3 = new Food("тема", LocalDate.now().minusDays(8),
                LocalDate.now().minusDays(1), 20, 0);
        Food milk4 = new Food("агуша", LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(7), 20, 0);
        Food milk5 = new Food("тема", LocalDate.now().minusDays(0),
                LocalDate.now().plusDays(7), 50, 0);
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.distribution(milk);
        controlQuality.distribution(cookie);
        controlQuality.distribution(milk1);
        controlQuality.distribution(cookie1);
        controlQuality.distribution(milk2);
        controlQuality.distribution(milk3);
        controlQuality.distribution(milk4);
        controlQuality.distribution(milk5);

        assertThat(shop.getStore()).isEqualTo(List.of(milk, cookie, milk1, cookie1));
        assertThat(warehouse.getStore()).isEqualTo(List.of(milk4, milk5));
        assertThat(trash.getStore()).isEqualTo(List.of(milk2, milk3));
        assertThat(shop.getStore().size()).isEqualTo(4);
        assertThat(trash.getStore().size()).isEqualTo(2);
        assertThat(warehouse.getStore().size()).isEqualTo(2);

    }
}