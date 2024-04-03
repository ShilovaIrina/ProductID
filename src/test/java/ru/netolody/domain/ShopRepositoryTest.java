package ru.netolody.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testProductId() {
        ShopRepository repo = new ShopRepository();

        Product productCard = new Product(9, "Альбом для рисования", 100);
        repo.add(productCard);
        repo.removeById(productCard.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-4);
        });
    }
}
