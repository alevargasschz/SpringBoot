package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Game;

public interface IGameService {
    // Aquí puedes definir los métodos que tu servicio de juegos debería implementar
    // Por ejemplo:
    List<Game> findAllGames();
    Game findGameById(Integer id);
    Game saveGame(Game game);
    void deleteGame(Integer id);
}
