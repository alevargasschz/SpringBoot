package com.example.demo.controller;

import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

import lombok.RequiredArgsConstructor;

// Anotamos la clase como un controlador REST para que Spring la reconozca como tal y pueda manejar las solicitudes HTTP.
@RestController

// Configuramos la ruta base para este controlador, por ejemplo, /users,
// lo que significa que todas las rutas definidas en este controlador comenzarán con /users.
@RequestMapping("/users")

@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping
    public Page<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/save")
    public User saveUser() {
        User user = new User();
        user.setUsername("nuevo_usuario");
        user.setEmail("nuevo_usuario@example.com");
        user.setPasswordHash("hashed_password");
        user.setBio("Esta es la biografía del nuevo usuario.");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return userService.saveUser(user);
    }
}
