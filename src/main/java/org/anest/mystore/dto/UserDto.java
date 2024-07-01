package org.anest.mystore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotEmpty(message = "Họ và tên không được để trống")
    private String fullName;

    @NotEmpty(message = "Tên người dùng không được để trống")
    private String username;

    @NotEmpty(message = "Mật khẩu không được để trống")
    private String password;

    @NotEmpty(message = "Xác nhận mật khẩu không được để trống")
    private String confirmPassword;

    @NotEmpty(message = "Số điện thoại không được để trống")
    private String mobile;
}
