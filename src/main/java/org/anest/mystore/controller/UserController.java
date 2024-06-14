package org.anest.mystore.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/account")
public class UserController {

    @GetMapping("/profile")
    public String profile(Model model) {
        return "pages/user/profile";
    }
}