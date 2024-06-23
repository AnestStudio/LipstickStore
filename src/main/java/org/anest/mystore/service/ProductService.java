package org.anest.mystore.service;

import org.anest.mystore.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<String> findDistinctColors();

    Page<Product> findProducts(
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
    );
}
