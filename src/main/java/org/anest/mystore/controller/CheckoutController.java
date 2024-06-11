package org.anest.mystore.controller;

import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.User;
import org.anest.mystore.entity.UserAddress;
import org.anest.mystore.repository.UserRepository;
import org.anest.mystore.service.UserAddressService;
import org.anest.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("checkout")
public class CheckoutController {

    private final UserService userService;
    private final UserAddressService userAddressService;

    @Autowired
    public CheckoutController(UserService userService, UserAddressService userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
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
}
