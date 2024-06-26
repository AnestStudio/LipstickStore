package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.repository.ProductRepository;
import org.anest.mystore.service.ProductService;
import org.anest.mystore.specification.Product2Specification;
import org.anest.mystore.specification.ProductSpecification;
import org.anest.mystore.specification.FilterCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Page<Product> findProducts(
            List<Long> categoryIds,
            List<Long> brandIds,
            String color,
            String name,
            Double minPrice,
            Double maxPrice,
            String sortField,
            String sortDir,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortField);
        Specification<Product> spec = ProductSpecification.findByCriteria(categoryIds, brandIds, color, name, minPrice, maxPrice);
        return productRepository.findAll(spec, pageable);
    }

//    public Page<Product> findProducts2(
//            List<Long> categoryIds,
//            List<Long> brandIds,
//            String color,
//            Double minPrice,
//            Double maxPrice,
//            String sortField,
//            String sortDir,
//            int page,
//            int size
//    ) {
//        List<Specification<Product>> specs = new ArrayList<>();
//
//        if (brandIds != null && !brandIds.isEmpty()) {
//            specs.add(new Product2Specification(new FilterCriteria("brand.id", "in", brandIds)));
//        }
//        if (categoryIds != null && !categoryIds.isEmpty()) {
//            specs.add(new Product2Specification(new FilterCriteria("category.id", "in", categoryIds)));
//        }
//        if (color != null && !color.isEmpty()) {
//            specs.add(new Product2Specification(new FilterCriteria("productColor", ":", color)));
//        }
//        if (minPrice != null) {
//            specs.add(new Product2Specification(new FilterCriteria("productPrice", ">", minPrice)));
//        }
//        if (maxPrice != null) {
//            specs.add(new Product2Specification(new FilterCriteria("productPrice", "<", maxPrice)));
//        }
//
//        Specification<Product> spec = specs.stream()
//                .reduce(Specification::and)
//                .orElse(null);
//
//        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortField);
//        return productRepository.findAll(spec, pageable);
//    }
}
