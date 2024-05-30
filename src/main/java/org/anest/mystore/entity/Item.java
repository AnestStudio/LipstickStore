package org.anest.mystore.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
public class Item implements Serializable {

    private Long id;
    private String name;
    private String image;
    private double price;
    private int quantity;
    private double amount;
}
