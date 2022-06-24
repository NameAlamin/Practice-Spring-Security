package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyCustomLoginPage")
    public String showLoginPage(Model model){
        return "auth/login";
    }
//    @GetMapping("/logout")
//    public String logout(){
//        return "auth/logout";
//    }
}
