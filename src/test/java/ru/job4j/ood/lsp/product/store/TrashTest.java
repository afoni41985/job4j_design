package ru.job4j.ood.lsp.product.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.product.model.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class TrashTest {


    @Test
    public void whenSuccessfullyAddToTrash() {
        Food milk = new Food("агуша", LocalDate.now().minusDays(8),
                LocalDate.now().minusDays(2), 20, 0);
        Food milk1 = new Food("тема", LocalDate.now().minusDays(8),
                LocalDate.now().minusDays(1), 20, 0);
        Trash trash = new Trash();
        trash.add(milk);
        trash.add(milk1);
        assertThat("агуша").isEqualTo(trash.getStore().get(0).getName());
        assertThat("тема").isEqualTo(trash.getStore().get(1).getName());

    }
}