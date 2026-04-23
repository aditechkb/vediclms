package com.sankhamtech.vediclms;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/login-success")
    public String loginSuccess(@AuthenticationPrincipal OAuth2User user) {

        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        return "Login successful. Email: " + email + ", Name: " + name;
    }
}