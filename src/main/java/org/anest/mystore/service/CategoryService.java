package org.anest.mystore.service;

import org.anest.mystore.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();
}
