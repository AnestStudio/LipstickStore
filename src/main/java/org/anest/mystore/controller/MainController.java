package org.anest.mystore.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.anest.mystore.dto.UserDto;
import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.User;
import org.anest.mystore.entity.UserDetail;
import org.anest.mystore.enums.RoleEnum;
import org.anest.mystore.enums.UserStatusEnum;
import org.anest.mystore.service.UserService;
import org.anest.mystore.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("\n\n\n===============================");
        System.out.println("USERNAME: " + null);
        System.out.println("===============================\n\n\n");

        session.invalidate();
        return "login";
    }

    @GetMapping("/register")
    public String registerLoad(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            BindingResult result
    ) {
        User emailExists = userService.findByEmail(userDto.getEmail());
        if (emailExists != null) {
            result.rejectValue("email", null, "Email đã được sử dụng.");
        }

        User usernameExists = userService.findByUsername(userDto.getUsername());
        if (usernameExists != null) {
            result.rejectValue("username", null, "Tên tài khoản đã được sử dụng.");
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Mật khẩu không khớp nhau.");
        }

        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setCreateAt(DateTimeUtil.getCurrentDateTime());
        user.setStatus(UserStatusEnum.ACTIVE.getValue());
        user.setDeleted(false);

        UserDetail userDetail = new UserDetail();
        userDetail.setUser(user);
        user.setUserDetail(userDetail);

        userService.save(user, RoleEnum.ROLE_MEMBER.name());
        return "redirect:/active-account?registered=success";
    }

    @GetMapping("/active-account")
    public String activeAccountLoad() {
        return "active-account";
    }

    @PostMapping("/active-account")
    public String activeAccountProcess(@RequestParam String username, @RequestParam String activeCode, Model model) {
        return "active-account";
    }

    @GetMapping("")
    public String index() {
        return "redirect:/products";
    }

    @GetMapping("/auth")
    @Transactional(propagation = Propagation.REQUIRED)
    public String auth(Model model, Principal principal, Authentication authentication) {
        String username = principal.getName();
        model.addAttribute("username", username);
        model.addAttribute("userRole", authentication.getAuthorities());

        AuthUser customUser = (AuthUser) authentication.getPrincipal();
        model.addAttribute("customUser", customUser);
        return "auth";
    }

    @GetMapping("/thanks")
    public String thanks(Model model) {
        return "pages/client/product/thanks";
    }
}
