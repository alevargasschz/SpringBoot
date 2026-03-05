package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer> {
    // Ya esta el CRUD básico con JpaRepository, pero se pueden agregar consultas personalizadas si es necesario

    // Consulta personalizada para obtener los commentarios creados entre dos fechas
    List<Comment> findByCreatedAtBetween (Timestamp startDate, Timestamp endDate);
}
