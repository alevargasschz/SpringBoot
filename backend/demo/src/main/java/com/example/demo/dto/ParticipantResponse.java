package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantResponse {
    private Integer id;
    private Integer score;
    private Integer position;
    private Boolean isWinner;
    private String username;
}
