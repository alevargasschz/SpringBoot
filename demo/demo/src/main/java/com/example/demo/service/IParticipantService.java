package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Participant;


public interface IParticipantService {
    List<Participant> findByWinner(boolean winner);
}
