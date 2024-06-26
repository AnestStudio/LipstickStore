package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Order;
import org.anest.mystore.repository.OrderRepository;
import org.anest.mystore.service.OrderService;
import org.anest.mystore.specification.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Order> getOrdersByStatusAndCurrentUser(List<Long> statusIds, String username, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Order> spec = OrderSpecification.findByCriteria(statusIds, username);
        return orderRepository.findAll(spec, pageable);
    }

    @Override
    public List<Object[]> countOrdersByStatusAndUsername(String username) {
        return orderRepository.countOrdersByStatusAndUsername(username);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
