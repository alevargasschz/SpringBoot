package com.example.demo.service.impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;
    private final IRoleService roleService;

    @Override
    public Page<User> findAllUsers() {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(0, 5);
        return userRepository.findAll(pageable);
    }

    @Override
    public User saveUser(User user) {
        Role role = roleService.findById(2);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
