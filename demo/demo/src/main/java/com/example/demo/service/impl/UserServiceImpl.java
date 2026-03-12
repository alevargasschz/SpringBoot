package com.example.demo.service.impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Page<User> findAllUsers(Integer offset, Integer pageSize) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(offset, pageSize, sort);
        return userRepository.findAll(pageable);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByIdUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
