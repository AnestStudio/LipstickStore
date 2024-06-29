package org.anest.mystore.controller.client;

import jakarta.servlet.http.HttpSession;
import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.Order;
import org.anest.mystore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("user")
public class UserOrderController {

    private final OrderService orderService;

    @Autowired
    public UserOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String orders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String statusIds,
            @AuthenticationPrincipal AuthUser authUser,
            Model model
    ) {
        List<Long> statusIdList = (statusIds != null && !statusIds.isEmpty())
                ? Arrays.stream(statusIds.split(",")).map(Long::parseLong).collect(Collectors.toList())
                : null;

        Page<Order> orderPage = orderService.getOrdersByStatusAndCurrentUser(statusIdList, authUser.getUsername(), page, size);
        model.addAttribute("resultPage", orderPage);
        return "pages/client/user/orders";
    }
}
