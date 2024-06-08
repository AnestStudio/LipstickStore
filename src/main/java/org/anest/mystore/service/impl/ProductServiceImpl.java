package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.repository.ProductRepository;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return repository.findByCategoryId(id);
    }

    @Override
    public List<Product> findByBrandId(Long id) {
        return repository.findByBrandId(id);
    }

    @Override
    public List<Product> findByProductNameContaining(String productName) {
        return repository.findByProductNameContaining(productName);
    }
}
