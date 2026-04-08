package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Participant;
import com.example.demo.service.IParticipantService;

import lombok.RequiredArgsConstructor;

// Anotamos la clase como un controlador REST para que Spring la reconozca como tal y pueda manejar las solicitudes HTTP.
@RestController

// Configuramos la ruta base para este controlador, por ejemplo, /users,
// lo que significa que todas las rutas definidas en este controlador comenzarán con /users.
@RequestMapping("/participants")

@RequiredArgsConstructor
public class ParticipantController {
    private final IParticipantService participantService;

    @GetMapping
    public List<Participant> getWinningParticipants() {
        return participantService.findByWinner(true);
    }
}
