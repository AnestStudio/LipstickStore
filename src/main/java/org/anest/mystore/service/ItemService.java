package org.anest.mystore.service;

import org.anest.mystore.entity.Item;

import java.util.List;

public interface ItemService {

    int countTotalProductQuantity(List<Item> items);

    double countTotalProductAmount(List<Item> items);
}
