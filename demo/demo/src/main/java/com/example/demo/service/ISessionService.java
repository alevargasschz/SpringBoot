package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Session;

public interface ISessionService {
    List<Session> findAll();
    Session findById(Integer id);
}
