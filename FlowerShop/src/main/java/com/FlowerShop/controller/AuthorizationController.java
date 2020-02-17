package com.FlowerShop.controller;

import com.FlowerShop.domain.Role;
import com.FlowerShop.domain.User;
import com.FlowerShop.models.RegistrationViewModel;
import com.FlowerShop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Collections;

@Controller
public class AuthorizationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user_exist")
    public String userExist(Model model) {
        model.addAttribute("message", "User exist!!!");
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(RegistrationViewModel reg) {
        User user = new User();
        User userFromDb = userRepo.findByUsername(reg.getUsername());
        user.setUsername(reg.getUsername());
        user.setEmail(reg.getEmail());
        user.setPassword(reg.getPassword());
        if (userFromDb != null) {
            return "redirect:/user_exist";
        } else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
            return "redirect:/login";
        }
    }


}
