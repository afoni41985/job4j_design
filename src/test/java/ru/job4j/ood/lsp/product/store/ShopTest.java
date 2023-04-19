package ru.job4j.ood.lsp.product.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.product.model.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class ShopTest {

    @Test
    public void whenSuccessfullyAddToShopNoDiscount() {
        Food milk = new Food("агуша", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(5), 100, 0);
        Food cookie = new Food("печенька", LocalDate.now().minusDays(4),
                LocalDate.now().plusDays(5), 200, 0);
        Shop shop = new Shop();
        shop.add(milk);
        shop.add(cookie);
        assertThat("агуша").isEqualTo(shop.getStore().get(0).getName());
        assertThat("печенька").isEqualTo(shop.getStore().get(1).getName());
    }

    @Test
    public void whenSuccessfullyAddToShopSetDiscount() {
        Food milk = new Food("агуша", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(1), 50, 20);
        Food cookie = new Food("печенька", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(1), 200, 15);
        double expected = milk.getPriceWithDiscount();
        double expected2 = cookie.getPriceWithDiscount();
        Shop shop = new Shop();
        shop.add(milk);
        shop.add(cookie);
        assertThat(expected).isEqualTo(shop.getStore().get(0).getPrice());
        assertThat(expected2).isEqualTo(shop.getStore().get(1).getPrice());


    }

}