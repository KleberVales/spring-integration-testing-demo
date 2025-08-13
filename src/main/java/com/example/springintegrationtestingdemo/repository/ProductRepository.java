package com.example.springintegrationtestingdemo.repository;

import com.example.springintegrationtestingdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
