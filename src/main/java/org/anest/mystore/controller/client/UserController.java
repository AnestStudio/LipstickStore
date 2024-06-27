package org.anest.mystore.controller.client;

import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.User;
import org.anest.mystore.service.UserAddressService;
import org.anest.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/account")
public class UserController {

    private final UserService userService;
    private final UserAddressService userAddressService;

    @Autowired
    public UserController(UserService userService, UserAddressService userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal AuthUser authUser, Model model) {
        User user = userService.findByUsername(authUser.getUsername());
        model.addAttribute("user", user);
        return "pages/client/user/profile";
    }

    @GetMapping("/update")
    public String updateProfile(@AuthenticationPrincipal AuthUser authUser, Model model) {
        User user = userService.findByUsername(authUser.getUsername());
        model.addAttribute("user", user);
        return "pages/client/user/update-profile";
    }

    @GetMapping("/address")
    public String address(@AuthenticationPrincipal AuthUser authUser, Model model) {
        User user = userService.findByUsername(authUser.getUsername());
        model.addAttribute("user", user);
        return "pages/client/user/address";
    }

    @GetMapping("/address/default/{addressId}")
    public String setDefaultAddress(
            @PathVariable Long addressId,
            @AuthenticationPrincipal AuthUser authUser,
            Model model
    ) {
        User user = userService.findByUsername(authUser.getUsername());
        userAddressService.changeDefaultAddress(user.getUserAddressList(), addressId);
        model.addAttribute("user", user);
        return "pages/client/user/address";
    }

    @GetMapping("/address/delete/{addressId}")
    public String deleteAddress(
            @PathVariable Long addressId,
            @AuthenticationPrincipal AuthUser authUser,
            Model model
    ) {
        User user = userService.findByUsername(authUser.getUsername());
        model.addAttribute("user", user);
        return "pages/client/user/address";
    }
}
