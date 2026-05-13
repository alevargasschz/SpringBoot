package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private Integer id;
    private String name;
    private String description;
    private Integer minPlayers;
    private Integer maxPlayers;
    private String category;
    private Integer userId;
    private String username;
}
