package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    // Ya esta el CRUD básico con JpaRepository, pero se pueden agregar consultas personalizadas si es necesario

    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameLike (String email);
    Optional<User> findByUsernameIgnoreCase(String email);
    Optional<User> findByCre(String email);
}
