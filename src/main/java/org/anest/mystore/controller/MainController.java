package org.anest.mystore.controller;

import jakarta.servlet.http.HttpSession;
import org.anest.mystore.entity.AuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("")
    public String index() {
        return "redirect:/products";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordLoad() {
        return "forgot-password";
    }

    @GetMapping("/auth")
    public String auth(Model model, Principal principal, Authentication authentication, @AuthenticationPrincipal AuthUser authUser) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("userRole", authentication.getAuthorities());
        model.addAttribute("authUser", authUser);
        return "auth";
    }

    @GetMapping("/thanks")
    public String thanks(Model model) {
        return "pages/client/product/thanks";
    }
}
