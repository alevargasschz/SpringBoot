package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.model.User;

public interface IUserService {
    Page<User> findAllUsers();

    User saveUser(User user);

    void deleteUser(Integer id);
}
