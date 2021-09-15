package com.serhan.springboogDeliveryApp.controllers;

import com.serhan.springboogDeliveryApp.model.User;
import com.serhan.springboogDeliveryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("firstName", userService.getLoggedUser().getFirstName());
        return "welcome";
    }

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));//or choose to use DTO
        userService.save(user);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

}
