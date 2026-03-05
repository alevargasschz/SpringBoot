package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface IUserService {
    List<User> findAllUsers();

    User saveUser(User user);

    void deleteUser(Integer id);
}
