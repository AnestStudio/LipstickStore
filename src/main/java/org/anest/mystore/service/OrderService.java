package org.anest.mystore.service;

import org.anest.mystore.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    Page<Order> getOrdersByStatusAndCurrentUser(List<Long> statusIds, String username, int page, int size);

    List<Object[]> countOrdersByStatusAndUsername(String username);

    Order save(Order order);
}
