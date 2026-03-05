package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Participant;

@Repository
public interface IParticipantRepository extends JpaRepository<Participant, Integer> {
    // Ya esta el CRUD básico con JpaRepository, pero se pueden agregar consultas personalizadas si es necesario

    // Consulta personalizada para obtener los participantes que ganaron o perdieron
    List<Participant> findByWinner(boolean winner);
}
