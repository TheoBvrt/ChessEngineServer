package ch.bouverat.chessengineapi.chessengineapi.controller;

import ch.bouverat.chessengineapi.chessengineapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameIdService;

    @PostMapping("start")
    public ResponseEntity<String> CreateGame() {
        String gameId = gameIdService.generateUniqueId();
        gameIdService.createGame(gameId);
        return ResponseEntity.ok(gameId);
    }
}
