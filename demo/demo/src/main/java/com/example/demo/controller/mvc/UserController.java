package com.example.demo.controller.mvc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;

import lombok.RequiredArgsConstructor;


@Controller("mvcUserController")
@RequestMapping("/mvc/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    private final IRoleService roleService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        User user = new User();
        List<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "users/add";
    }

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userService.saveUser(user);
        return "";
    }
}
