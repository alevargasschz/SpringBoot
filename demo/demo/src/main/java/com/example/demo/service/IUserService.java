package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.model.User;

public interface IUserService {
    Page<User> findAllUsers(Integer offset, Integer pageSize);

    User saveUser(User user);

    void deleteUser(Integer id);

    User findByIdUser(Integer id);
}
