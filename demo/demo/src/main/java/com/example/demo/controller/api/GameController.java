package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GameRequest;
import com.example.demo.dto.GameResponse;
import com.example.demo.model.Game;
import com.example.demo.model.User;
import com.example.demo.service.IGameService;
import com.example.demo.service.IUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/public/games")
public class GameController {
    private final IGameService gameService;
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<GameResponse>> getAllGames() {
        List<Game> games = gameService.findAllGames();
        List<GameResponse> response = games.stream()
                .map(game -> new GameResponse(
                        game.getId(),
                        game.getName(),
                        game.getDescription(),
                        game.getMinPlayers(),
                        game.getMaxPlayers(),
                        game.getCategory(),
                        game.getCreatedBy().getUsername()
                ))
                .toList();
        return ResponseEntity.ok(response);
        // return ResponceEntity.status(HttpStatus.OK).body(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameById(@PathVariable Integer id) {
        try {
            Game game = gameService.findGameById(id);
            GameResponse response = new GameResponse(
                    game.getId(),
                    game.getName(),
                    game.getDescription(),
                    game.getMinPlayers(),
                    game.getMaxPlayers(),
                    game.getCategory(),
                    game.getCreatedBy().getUsername());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving game: " + e.getMessage());
                    
        }
    }
    
    @PostMapping()
    public ResponseEntity<Game> postMethodName(@RequestBody GameRequest gameRequest) {

        try {
            User creator = userService.findByIdUser(gameRequest.getCreatorId());

            Game game = new Game();
            game.setName(gameRequest.getName());
            game.setDescription(gameRequest.getDescription());
            game.setMinPlayers(gameRequest.getMinPlayers());
            game.setMaxPlayers(gameRequest.getMaxPlayers());
            game.setCategory(gameRequest.getCategory());
            game.setCreatedBy(creator);
            Game savedGame = gameService.saveGame(game);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
