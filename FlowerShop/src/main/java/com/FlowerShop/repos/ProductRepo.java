package com.FlowerShop.repos;

import com.FlowerShop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByName(String name);

    List<Product> findByType(String type);
}
