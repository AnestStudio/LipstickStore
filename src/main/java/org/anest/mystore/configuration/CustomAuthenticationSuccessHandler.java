package org.anest.mystore.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.enums.UserStatusEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        int statusCode = authUser.getStatus();

        UserStatusEnum status = UserStatusEnum.fromValue(statusCode);
        switch (status) {
            case PENDING:
                response.sendRedirect("/active-account");
                break;
            case ACTIVE:
            case REPORTED:
                response.sendRedirect("/");
                break;
            case LOCKED:
                response.sendRedirect("/login?locked=true");
                break;
            default:
                response.sendRedirect("/login?error=true");
        }
    }
}
