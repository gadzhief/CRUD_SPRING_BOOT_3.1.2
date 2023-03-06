package com.projectx.crudapp.controllers;


import com.projectx.crudapp.model.User;
import com.projectx.crudapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {


    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/create")
    public String createUserForm(Model model) {
    model.addAttribute("user", new User());
    return "create";
}


    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("edit/{id}")
    public String updateUserForm(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }
    @PostMapping("edit/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.getUserById(id);
        userService.saveUser(user);

        return "redirect:/users";
    }

}
