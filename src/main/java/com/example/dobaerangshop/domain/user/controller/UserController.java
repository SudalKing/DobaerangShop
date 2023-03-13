package com.example.dobaerangshop.domain.user.controller;

import com.example.dobaerangshop.domain.user.dto.UserDto;
import com.example.dobaerangshop.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login-form";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login-form";
    }

    @GetMapping("/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/register")
    public String register(UserDto userDto){
        userService.saveUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/admin-page")
    public String admin(){
        return "admin-page";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER')")
    @GetMapping("/user-page")
    public String user(){
        return "user-page";
    }

}
