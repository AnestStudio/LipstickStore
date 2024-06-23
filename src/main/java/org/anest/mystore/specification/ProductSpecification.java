package org.anest.mystore.specification;

import jakarta.persistence.criteria.Predicate;
import org.anest.mystore.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Product> findByCriteria(List<Long> categoryIds, List<Long> brandIds, String color, String name) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (categoryIds != null && !categoryIds.isEmpty()) {
                predicates.add(root.get("category").get("id").in(categoryIds));
            }

            if (brandIds != null && !brandIds.isEmpty()) {
                predicates.add(root.get("brand").get("id").in(brandIds));
            }

            if (color != null && !color.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("productColor"), "%" + color + "%"));
            }

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("productName"), "%" + name + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
