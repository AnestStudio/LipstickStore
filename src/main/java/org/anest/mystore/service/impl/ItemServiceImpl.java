package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Item;
import org.anest.mystore.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public int countTotalProductQuantity(List<Item> items) {
        return items.stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }
}
