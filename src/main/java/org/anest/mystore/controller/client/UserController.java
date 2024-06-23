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
@RequestMapping("user/account")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal AuthUser authUser, Model model) {
        User user = userService.findByUsername(authUser.getUsername());
        model.addAttribute("user", user);
        return "pages/client/user/profile";
    }
}
