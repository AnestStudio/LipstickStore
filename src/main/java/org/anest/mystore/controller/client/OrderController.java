package org.anest.mystore.controller.client;

import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.User;
import org.anest.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class OrderController {

    private final UserService userService;

    @Autowired
    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/orders")
    public String orders(@AuthenticationPrincipal AuthUser authUser, Model model) {
        User user = userService.findByUsername(authUser.getUsername());
        model.addAttribute("user", user);
        return "pages/client/user/orders";
    }
}
