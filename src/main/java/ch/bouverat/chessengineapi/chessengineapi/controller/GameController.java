package ch.bouverat.chessengineapi.chessengineapi.controller;

import ch.bouverat.chessengineapi.chessengineapi.service.GameJoinRequest;
import ch.bouverat.chessengineapi.chessengineapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameIdService;

    public GameController(GameService gameIdService) {
        this.gameIdService = gameIdService;
    }

    @PostMapping("start")
    public ResponseEntity<String> CreateGame(@RequestBody String macAddress) {
        String gameId = gameIdService.generateUniqueId();
        System.out.println(macAddress);
        gameIdService.createGame(gameId, macAddress);
        return ResponseEntity.ok(gameId);
    }

    @PostMapping("join")
    public ResponseEntity<Integer> JoinGame(@RequestBody GameJoinRequest gameJoinRequest) {
        String gameId = gameJoinRequest.getGameId();
        String player2Ip = gameJoinRequest.getPlayer2Ip();

        System.out.println(player2Ip);
        if (gameIdService.getGameIdList().contains(gameId)) {
            gameIdService.getGameList().get(gameId).setPlayer2Ip(player2Ip);
            gameIdService.getGameList().get(gameId).printPlayerIp();
            return ResponseEntity.ok(0);
        } else {
            return ResponseEntity.ok(1);
        }
    }
}
