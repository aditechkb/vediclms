package com.sankhamtech.vediclms.authentication.handler;

import com.sankhamtech.vediclms.common.constants.AppConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();

        String email = oauthUser.getAttribute("email");

        // TODO: call AuthService to check DB
        boolean userExists = true; // replace with actual check

        if (userExists) {
            response.sendRedirect(AppConstants.DASHBOARD_URL);
        } else {
            response.sendRedirect(AppConstants.PURCHASE_PAGE);
        }
    }
}