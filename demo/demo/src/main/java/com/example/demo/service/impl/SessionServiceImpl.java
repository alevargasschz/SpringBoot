package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Session;
import com.example.demo.repository.ISessionRepository;
import com.example.demo.service.ISessionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements ISessionService {
    private final ISessionRepository sessionRepository;

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session findById(Integer id) {
        return sessionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Session not found"));
    }
}
