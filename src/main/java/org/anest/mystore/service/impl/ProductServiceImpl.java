package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.repository.ProductRepository;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findByProductId(Long id) {
        return repository.findByProductId(id);
    }

    @Override
    public List<Product> findByCategoryCategoryId(Long id) {
        return repository.findByCategoryCategoryId(id);
    }

    @Override
    public List<Product> findByProductNameContaining(String productName) {
        return repository.findByProductNameContaining(productName);
    }
}
