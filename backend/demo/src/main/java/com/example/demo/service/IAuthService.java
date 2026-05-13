package com.example.demo.service;

import com.example.demo.dto.AuthResponse;

public interface IAuthService {
    AuthResponse login(String username, String password);
}
