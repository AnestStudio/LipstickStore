package org.anest.mystore.specification;

import jakarta.persistence.criteria.Predicate;
import org.anest.mystore.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class OrderSpecification {

    public static Specification<Order> findByCriteria(List<Long> statusIds, String username) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (statusIds != null && !statusIds.isEmpty()) {
                predicates.add(root.get("orderStatus").get("id").in(statusIds));
            }

            if (username != null && !username.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("user").get("username"), username));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
