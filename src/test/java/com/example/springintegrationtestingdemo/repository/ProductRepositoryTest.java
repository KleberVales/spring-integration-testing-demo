package com.example.springintegrationtestingdemo.repository;

import com.example.springintegrationtestingdemo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void testSaveAndFindAll() {
        repository.save(new Product("Laptop", 3500.00));
        List<Product> products = repository.findAll();

        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Laptop");
    }
}
