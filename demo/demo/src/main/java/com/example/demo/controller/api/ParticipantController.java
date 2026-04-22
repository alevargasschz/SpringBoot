package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParticipantResponse;
import com.example.demo.model.Participant;
import com.example.demo.service.IParticipantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/participants")
public class ParticipantController {
    private final IParticipantService participantService;

    @GetMapping
    public ResponseEntity<List<ParticipantResponse>> getAllParticipants() {
        List<Participant> participants = participantService.findAll();
        List<ParticipantResponse> response = participants.stream()
                .map(participant -> new ParticipantResponse(
                        participant.getId(),
                        participant.getScore(),
                        participant.getPosition(),
                        participant.getIsWinner(),
                        participant.getUserId().getUsername()
                ))
                .toList();
        return ResponseEntity.ok(response);
        // return ResponceEntity.status(HttpStatus.OK).body(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getParticipantById(@PathVariable Integer id) {
        try {
            Participant participant = participantService.findById(id);
            ParticipantResponse response = new ParticipantResponse(
                    participant.getId(),
                    participant.getScore(),
                    participant.getPosition(),
                    participant.getIsWinner(),
                    participant.getUserId().getUsername()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving participant: " + e.getMessage());
        }
    }
}
