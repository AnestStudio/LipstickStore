package org.anest.mystore.controller;

import jakarta.validation.Valid;
import org.anest.mystore.constant.IConstants;
import org.anest.mystore.dto.UserDto;
import org.anest.mystore.entity.User;
import org.anest.mystore.entity.UserDetail;
import org.anest.mystore.enums.RoleEnum;
import org.anest.mystore.enums.UserStatusEnum;
import org.anest.mystore.service.UserDetailService;
import org.anest.mystore.service.UserService;
import org.anest.mystore.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final UserDetailService userDetailService;

    @Autowired
    public RegistrationController(UserService userService, UserDetailService userDetailService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
    }

    @GetMapping("/register")
    public String registerLoad(UserDto userDto) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(
            @Valid @ModelAttribute("userDto") UserDto userDto,
            BindingResult result
    ) {
        User emailExists = userService.findByEmail(userDto.getEmail());
        if (emailExists != null) {
            result.rejectValue("email", null, "Email đã được sử dụng");
        }

        User usernameExists = userService.findByUsername(userDto.getUsername());
        if (usernameExists != null) {
            result.rejectValue("username", null, "Tên tài khoản đã được sử dụng");
        }

        UserDetail mobileExists = userDetailService.findByMobile(userDto.getMobile());
        if (mobileExists != null) {
            result.rejectValue("mobile", null, "Số điện thoại đã được sử dụng");
        }
        if (!userDto.getMobile().matches(IConstants.MOBILE_REGEX)) {
            result.rejectValue("mobile", null, "Số điện thoại không hợp lệ");
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Mật khẩu không khớp nhau");
        }

        if (result.hasErrors()) {
            return "register";
        }

        User user = getUser(userDto);
        userService.save(user, RoleEnum.ROLE_MEMBER.name());

        // Send activation email

        return "redirect:/active-account?registered=success";
    }

    private User getUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setCreateAt(DateTimeUtil.getCurrentDateTime());
        user.setStatus(UserStatusEnum.ACTIVE.getValue());
        user.setDeleted(false);
        user.setEnabled(false);
        // Generate activation code
        String activationCode = UUID.randomUUID().toString();
        user.setActivationCode(activationCode);

        UserDetail userDetail = new UserDetail();
        userDetail.setMobile(userDto.getMobile());
        userDetail.setUser(user);
        user.setUserDetail(userDetail);
        return user;
    }

    @GetMapping("/active-account")
    public String activeAccountLoad() {
        return "active-account";
    }

    @PostMapping("/active-account")
    public String activeAccountProcess(@RequestParam String activeCode, Model model) {
        User user = userService.findByActivationCode(activeCode);
        if (user != null) {
            user.setEnabled(true);
            user.setActivationCode(null);
            userService.save(user);
            return "login";
        } else {
            return "active-account";
        }
    }
}
