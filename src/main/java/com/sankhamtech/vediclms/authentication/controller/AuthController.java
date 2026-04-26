package com.sankhamtech.vediclms.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/public/login")
    public String loginPage() {
        return "public/login"; // maps to templates/login.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/public/purchase")
    public String purchase() {
        return "public/purchase";
    }
}