package com.example.springintegrationtestingdemo.controller;

import com.example.springintegrationtestingdemo.entity.Product;
import com.example.springintegrationtestingdemo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository repository;

    @Test
    void testGetAllProducts() {
        repository.save(new Product("Phone", 2000.00));

        List<?> products = this.restTemplate.getForObject("http://localhost:" + port + "/products", List.class);

        assertThat(products).hasSize(1);
    }
}
