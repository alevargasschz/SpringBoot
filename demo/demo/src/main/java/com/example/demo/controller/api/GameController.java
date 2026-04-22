package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GameResponse;
import com.example.demo.model.Game;
import com.example.demo.service.IGameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/games")
public class GameController {
    private final IGameService gameService;

    @GetMapping
    public ResponseEntity<List<GameResponse>> getAllGames() {
        List<Game> games = gameService.findAllGames();
        List<GameResponse> response = games.stream()
                .map(game -> new GameResponse(game.getId(), game.getName(), game.getDescription()))
                .toList();
        return ResponseEntity.ok(response);
        // return ResponceEntity.status(HttpStatus.OK).body(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameById(@PathVariable Integer id) {
        try {
            Game game = gameService.findGameById(id);
            GameResponse response = new GameResponse(game.getId(), game.getName(), game.getDescription());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving game: " + e.getMessage());
        }
    }

}
