package org.anest.mystore.service;

import org.anest.mystore.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> findById(Long brandId);
}