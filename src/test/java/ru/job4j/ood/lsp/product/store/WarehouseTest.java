package ru.job4j.ood.lsp.product.store;


import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.product.model.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class WarehouseTest {

    @Test
    public void whenSuccessfullyAddToWarehouse() {
        Food milk = new Food("агуша", LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(7), 20, 0);
        Food milk1 = new Food("тема", LocalDate.now().minusDays(0),
                LocalDate.now().plusDays(7), 50, 0);
        Warehouse warehouse = new Warehouse();
        warehouse.add(milk);
        warehouse.add(milk1);
        assertThat("агуша").isEqualTo(warehouse.getStore().get(0).getName());
        assertThat("тема").isEqualTo(warehouse.getStore().get(1).getName());


    }
}