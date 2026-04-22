package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Participant;
import com.example.demo.repository.IParticipantRepository;
import com.example.demo.service.IParticipantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements IParticipantService {
    private final IParticipantRepository participantRepository;

    @Override
    public List<Participant> findByWinner(boolean isWinner) {
        return participantRepository.findByIsWinner(isWinner);
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public Participant findById(Integer id) {
        return participantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Participant not found"));
    }
}
