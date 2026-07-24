package com.paran.safety_docs.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginForm() {
        return "admin/login";
    }

}
