package com.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHomePage(Principal principal, Authentication authentication, Model model){
        String username = principal.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        model.addAttribute("username",username);
        model.addAttribute("roles",authorities);
        return "home";
    }
    @GetMapping("/dashboard/admin")
    public String showAdminDashboard(){
        return "dashboard/admin";
    }
    @GetMapping("/dashboard/teacher")
    public String showTeacherDashboard(){
        return "dashboard/teacher";
    }
    @GetMapping("/dashboard/student")
    public String showStudentDashboard(){
        return "dashboard/student";
    }
}
