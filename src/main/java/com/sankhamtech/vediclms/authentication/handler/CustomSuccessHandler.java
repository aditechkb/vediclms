package com.sankhamtech.vediclms.authentication.handler;

import com.sankhamtech.vediclms.common.constants.AppConstants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public CustomSuccessHandler() {
        // Default redirect after successful login
        setDefaultTargetUrl(AppConstants.DASHBOARD_URL);

        // Always go to dashboard (ignore previous saved request)
        setAlwaysUseDefaultTargetUrl(true);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
        String email = oauthUser.getAttribute("email");

        // TODO: Replace with actual DB check
        boolean userExists = true;

        if (!userExists) {
            // If user not allowed → redirect to purchase page
            getRedirectStrategy().sendRedirect(request, response, AppConstants.PURCHASE_PAGE);
            return;
        }

        // If user is valid → continue normal Spring flow (redirect to dashboard)
        super.onAuthenticationSuccess(request, response, authentication);
    }
}