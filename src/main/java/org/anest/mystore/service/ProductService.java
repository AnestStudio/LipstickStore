package org.anest.mystore.service;

import org.anest.mystore.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByCategoryId(Long id);

    List<Product> findByBrandId(Long id);

    List<Product> findByProductNameContaining(String productName);
}
