package com.geekbrains.java.springboot.controllers;

import com.geekbrains.java.springboot.models.User;
import com.geekbrains.java.springboot.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("Users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/show_user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute("Users", userService.getUserById(id));
        return "user_page";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.removeUserById(id);
        return "redirect:/users/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("Users", userService.getUserById(id));
        return "user_edit_page";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/add")
    public String showUserAddForm() {
        return "add_user_form";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/all";
    }
}
