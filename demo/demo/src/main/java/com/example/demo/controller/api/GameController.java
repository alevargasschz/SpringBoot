package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import org.springframework.web.bind.annotation.PutMapping;



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
    
    @PostMapping("/create")
    public ResponseEntity<GameResponse> postMethodName(@RequestBody GameRequest gameRequest) {

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

            GameResponse response = new GameResponse(
                    savedGame.getId(),
                    savedGame.getName(),
                    savedGame.getDescription(),
                    savedGame.getMinPlayers(),
                    savedGame.getMaxPlayers(),
                    savedGame.getCategory(),
                    savedGame.getCreatedBy().getUsername());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<GameResponse> putMethodName(@PathVariable Integer id, @RequestBody GameRequest gameRequest) {

        try {
            Game game = gameService.findGameById(id);
            User creator = userService.findByIdUser(gameRequest.getCreatorId());

            game.setName(gameRequest.getName());
            game.setDescription(gameRequest.getDescription());
            game.setMinPlayers(gameRequest.getMinPlayers());
            game.setMaxPlayers(gameRequest.getMaxPlayers());
            game.setCategory(gameRequest.getCategory());
            game.setCreatedBy(creator);
            Game savedGame = gameService.saveGame(game);

            GameResponse response = new GameResponse(
                    savedGame.getId(),
                    savedGame.getName(),
                    savedGame.getDescription(),
                    savedGame.getMinPlayers(),
                    savedGame.getMaxPlayers(),
                    savedGame.getCategory(),
                    savedGame.getCreatedBy().getUsername()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GameResponse> deleteGame(@PathVariable Integer id) {
        try {
            Game game = gameService.findGameById(id);
            gameService.deleteGame(id);
            GameResponse response = new GameResponse(
                    game.getId(),
                    game.getName(),
                    game.getDescription(),
                    game.getMinPlayers(),
                    game.getMaxPlayers(),
                    game.getCategory(),
                    game.getCreatedBy().getUsername()
            );
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
