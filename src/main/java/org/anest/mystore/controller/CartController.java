package org.anest.mystore.controller;

import jakarta.servlet.http.HttpSession;
import org.anest.mystore.entity.Item;
import org.anest.mystore.service.ItemService;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    private final ProductService productService;
    private final ItemService itemService;

    @Autowired
    public CartController(ProductService productService, ItemService itemService) {
        this.productService = productService;
        this.itemService = itemService;
    }

    @GetMapping("")
    public String goToCart(Model model) {
        return "pages/cart";
    }

    @GetMapping("/item/delete/{itemId}")
    public String deleteItemInCart(@PathVariable Long itemId, HttpSession session) {
        List<Item> items = (List<Item>) session.getAttribute("cart");
        items.removeIf(item -> item.getId().equals(itemId));
        session.setAttribute("cart", items);
        session.setAttribute("totalProductInCart", itemService.countTotalProductQuantity(items));
        session.setAttribute("totalAmountOfCart", itemService.countTotalProductAmount(items));
        return "pages/cart";
    }

    @GetMapping("/delete")
    public String deleteCart(HttpSession session) {
        session.removeAttribute("cart");
        session.removeAttribute("totalProductInCart");
        session.removeAttribute("totalAmountOfCart");
        return "pages/cart";
    }
}
