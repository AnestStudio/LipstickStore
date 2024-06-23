package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.enums.SortTypeEnum;
import org.anest.mystore.repository.ProductRepository;
import org.anest.mystore.service.ProductService;
import org.anest.mystore.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findByBrandId(Long id) {
        return productRepository.findByBrandId(id);
    }

    @Override
    public List<Product> findByProductNameContaining(String productName) {
        return productRepository.findByProductNameContaining(productName);
    }

    @Override
    public List<Product> getAllSorted(String sortType) {
        return SortTypeEnum.ASC.getValue().equalsIgnoreCase(sortType)
            ? productRepository.findAllByOrderByProductPriceAsc()
            : productRepository.findAllByOrderByProductPriceDesc();
    }

    @Override
    public Page<Product> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findProducts(
            List<Long> categoryIds,
            List<Long> brandIds,
            String color,
            String name,
            int page,
            int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Product> spec = ProductSpecification.findByCriteria(categoryIds, brandIds, color, name);
        return productRepository.findAll(spec, pageable);
    }

    @Override
    public long countTotalProducts() {
        return productRepository.count();
    }
}
