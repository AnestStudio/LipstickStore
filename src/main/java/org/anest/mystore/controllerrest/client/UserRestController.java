package org.anest.mystore.controllerrest.client;

import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserRestController {

    private final OrderService orderService;

    @Autowired
    public UserRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/status-count")
    public ResponseEntity<List<Object[]>> countOrdersByStatus(@AuthenticationPrincipal AuthUser authUser) {
        List<Object[]> orderStatusCountList = orderService.countOrdersByStatusAndUsername(authUser.getUsername());
        return new ResponseEntity<>(orderStatusCountList, HttpStatus.OK);
    }
}
