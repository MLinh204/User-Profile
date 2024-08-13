package com.example.userprofile.controller;

import com.example.userprofile.model.User;
import com.example.userprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "home";
    }
    @GetMapping("/{id}")
    public String getUserProfile(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "userProfileDetail";
    }
    @GetMapping("/create")
    public String getCreateForm(Model model){
        model.addAttribute("user", new User());
        return "createUserProfileForm";
    }
    @PostMapping("/create")
    public String createUserProfile(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getEditUserForm (@PathVariable Long id, Model model){
        User user = userService.getUserById(id);
        if(user ==null){
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "editUserProfileForm";
    }
    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User updatedUser){
        userService.editUser(id,updatedUser);
        return "redirect:/users/" + id;
    }
}
