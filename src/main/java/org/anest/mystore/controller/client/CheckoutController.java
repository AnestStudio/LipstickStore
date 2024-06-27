package org.anest.mystore.controller.client;

import jakarta.servlet.http.HttpSession;
import org.anest.mystore.entity.*;
import org.anest.mystore.service.OrderService;
import org.anest.mystore.service.UserAddressService;
import org.anest.mystore.service.UserService;
import org.anest.mystore.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.anest.mystore.constant.IConstants.*;

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
    public String checkout(@AuthenticationPrincipal AuthUser authUser, Model model) {
        User user = userService.findByUsername(authUser.getUsername());
        UserAddress defaultAddress = userAddressService.getUserDefaultAddress(user.getUserAddressList());

        model.addAttribute("user", user);
        model.addAttribute("defaultAddress", defaultAddress);
        return "pages/client/product/checkout";
    }

    @GetMapping("/process")
    public String orderProcess(
            @RequestParam(required = false, defaultValue = "") String orderNote,
            @RequestParam Long userShippingAddressId,
            @AuthenticationPrincipal AuthUser authUser,
            HttpSession session
    ) {
        User user = userService.findByUsername(authUser.getUsername());

        Order order = new Order();
        order.setUser(user);
        order.setOrderCreatedAt(DateTimeUtil.getCurrentDateTime());
        order.setOrderStatus(new OrderStatus(1L, null, null));
        order.setOrderDiscount(0);
        order.setOrderTotalAmount(Double.parseDouble(session.getAttribute(TOTAL_AMOUNT_OF_CART).toString()));
        order.setOrderNote(orderNote);

        UserAddress userAddress = userAddressService.getAddressById(user.getUserAddressList(), userShippingAddressId);
        order.setReceiverName(userAddress.getReceiverName());
        order.setReceiverMobile(userAddress.getReceiverMobile());
        order.setShippingAddress(userAddress.getFullAddress());

        order.setOrderDetailList(getOrderDetailList((List<Item>) session.getAttribute(CART), order));

        Order savedOrder = orderService.save(order);
        if (savedOrder != null) {
            session.removeAttribute(CART);
            session.removeAttribute(TOTAL_PRODUCT_IN_CART);
            session.removeAttribute(TOTAL_AMOUNT_OF_CART);
        }
        return "pages/client/product/thanks";
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
}
