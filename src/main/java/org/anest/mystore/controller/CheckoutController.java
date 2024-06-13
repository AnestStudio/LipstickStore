package org.anest.mystore.controller;

import jakarta.servlet.http.HttpSession;
import org.anest.mystore.entity.*;
import org.anest.mystore.service.OrderService;
import org.anest.mystore.service.UserAddressService;
import org.anest.mystore.service.UserService;
import org.anest.mystore.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("checkout")
public class CheckoutController {

    private final UserService userService;
    private final UserAddressService userAddressService;
    private final OrderService orderService;

    @Autowired
    public CheckoutController(UserService userService, UserAddressService userAddressService, OrderService orderService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
        this.orderService = orderService;
    }

    @GetMapping("")
    public String checkout(Authentication auth, Model model) {
        AuthUser authUser = (AuthUser) auth.getPrincipal();
        User user = userService.findByUsername(authUser.getUsername());
        UserAddress defaultAddress = userAddressService.getUserDefaultAddress(user.getUserAddressList());

        model.addAttribute("user", user);
        model.addAttribute("defaultAddress", defaultAddress);
        return "pages/checkout";
    }

    @GetMapping("/order")
    public String order(
            @RequestParam String orderNote,
            @RequestParam Long userShippingAddressId,
            Authentication auth,
            Model model,
            HttpSession session
    ) {
        AuthUser authUser = (AuthUser) auth.getPrincipal();
        User user = userService.findByUsername(authUser.getUsername());

        Order order = new Order();
        order.setUser(user);
        order.setOrderCreatedAt(DateTimeUtil.getCurrentDateTime());
        order.setOrderStatus(new OrderStatus(1L, null, null));
        order.setOrderDiscount(0);
        order.setOrderTotalAmount(Double.parseDouble(session.getAttribute("totalAmountOfCart").toString()));
        order.setOrderNote(orderNote);

        UserAddress userAddress = getUserShippingAddress(user.getUserAddressList(), userShippingAddressId);
        order.setReceiverName(userAddress.getReceiverName());
        order.setReceiverMobile(userAddress.getReceiverMobile());
        order.setShippingAddress(userAddress.getFullAddress());
        order.setOrderDetailList(getOrderDetailList((List<Item>) session.getAttribute("cart"), order));

        orderService.save(order);
        return "thanks";
    }

    private List<OrderDetail> getOrderDetailList(List<Item> items, Order order) {

        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (Item item : items) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(item.getId());
            orderDetail.setProductName(item.getName());
            orderDetail.setProductColor(item.getColor());
            orderDetail.setProductImage(item.getImage());
            orderDetail.setProductPrice(item.getPrice());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setAmount(item.getAmount());
            orderDetail.setOrder(order);
            orderDetailList.add(orderDetail);
        }
        return orderDetailList;
    }

    private UserAddress getUserShippingAddress(List<UserAddress> userAddressList, Long userShippingAddressId) {
        for (UserAddress userAddress : userAddressList) {
            if (Objects.equals(userAddress.getId(), userShippingAddressId)) {
                return userAddress;
            }
        }
        return null;
    }
}
