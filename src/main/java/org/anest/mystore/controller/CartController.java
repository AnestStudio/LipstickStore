package org.anest.mystore.controller;

import org.anest.mystore.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cart")
public class CartController {

    @GetMapping("")
    public String goToCart(Model model) {
        return "pages/cart";
    }

    @GetMapping("/test")
    public ResponseEntity<Item> addItem() {
        Item item = Item.builder()
                .id(22L)
                .name("Son XX VV 123")
                .image("")
                .price(890000)
                .quantity(1)
                .amount(890000)
                .build();

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
