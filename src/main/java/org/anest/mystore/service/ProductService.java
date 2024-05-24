package org.anest.mystore.service;

import org.anest.mystore.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findByProductId(Long id);

    List<Product> findByCategoryCategoryId(Long id);

    List<Product> findByProductNameContaining(String productName);
}
