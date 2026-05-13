package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Role;


public interface IRoleService {
    Role findById(Integer id);

    List<Role> findAll();
}
