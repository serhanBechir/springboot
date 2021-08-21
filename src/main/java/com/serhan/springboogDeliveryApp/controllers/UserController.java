package com.serhan.springboogDeliveryApp.controllers;

import com.serhan.springboogDeliveryApp.model.User;
import com.serhan.springboogDeliveryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping("/index")
    public String index(){
        return "index.html";
    }

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){//or choose to use DTO
        userService.save(user);
        return "redirect:/register?success";
    }
}
