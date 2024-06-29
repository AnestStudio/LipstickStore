package org.anest.mystore.controller.client;

import jakarta.servlet.http.HttpSession;
import org.anest.mystore.entity.Item;
import org.anest.mystore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.anest.mystore.constant.IConstants.*;

@Controller
@RequestMapping("cart")
public class CartController {

    private final ItemService itemService;

    @Autowired
    public CartController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String goToCart() {
        return "pages/client/product/cart";
    }

    @GetMapping("/delete")
    public String deleteCart(HttpSession session) {
        clearCart(session);
        return "pages/client/product/cart";
    }

    @GetMapping("/delete/{itemId}")
    public String deleteItemInCart(@PathVariable Long itemId, HttpSession session) {
        List<Item> items = (List<Item>) session.getAttribute(CART);
        items.removeIf(item -> item.getId().equals(itemId));
        if (items.isEmpty()) {
            clearCart(session);
        } else {
            session.setAttribute(CART, items);
            session.setAttribute(TOTAL_PRODUCT_IN_CART, itemService.countTotalProductQuantity(items));
            session.setAttribute(TOTAL_AMOUNT_OF_CART, itemService.countTotalProductAmount(items));
        }
        return "pages/client/product/cart";
    }

    private void clearCart(HttpSession session) {
        session.removeAttribute(CART);
        session.removeAttribute(TOTAL_PRODUCT_IN_CART);
        session.removeAttribute(TOTAL_AMOUNT_OF_CART);
    }
}
