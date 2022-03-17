package com.example.casestudy4_springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SigninController {
    @GetMapping("/login")
    public String login() {
        return "sign-in";
    }
}