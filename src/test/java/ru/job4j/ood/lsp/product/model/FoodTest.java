package ru.job4j.ood.lsp.product.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class FoodTest {

    @Test
    void whenGetPriceWithDiscount() {
        Food food = new Food("агуша", LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(7), 100, 25);
        assertThat(food.getPriceWithDiscount()).isEqualTo(75);
    }
}