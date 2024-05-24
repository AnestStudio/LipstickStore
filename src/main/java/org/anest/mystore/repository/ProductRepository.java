package org.anest.mystore.repository;

import org.anest.mystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product findByProductId(Long id);

    List<Product> findByCategoryCategoryId(Long id);

    List<Product> findByProductNameContaining(String productName);
}
