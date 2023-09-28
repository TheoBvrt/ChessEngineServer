package ch.bouverat.chessengineapi.chessengineapi.controller;

import ch.bouverat.chessengineapi.chessengineapi.model.ChessGame;
import ch.bouverat.chessengineapi.chessengineapi.service.GameJoinRequest;
import ch.bouverat.chessengineapi.chessengineapi.service.GameService;
import ch.bouverat.chessengineapi.chessengineapi.service.GameStatusRequest;
import ch.bouverat.chessengineapi.chessengineapi.service.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("send-map")
    public void UpdateMap(@RequestBody UpdateRequest updateRequest) {
        String gameId = updateRequest.getGameId();
        String jsonMap = updateRequest.getJsonMap();
        System.out.println(gameId);

        if (gameIdService.getGameIdList().contains(gameId)) {
            ChessGame chessGame =  gameIdService.getGameList().get(gameId);
            if (chessGame.getPlayerToPlay() == 0)
                chessGame.setPlayerToPlay(1);
            else if (chessGame.getPlayerToPlay() == 1)
                chessGame.setPlayerToPlay(0);
            System.out.println(chessGame.getPlayerToPlay());
            chessGame.updateMap(jsonMap);
        }
    }

    @PostMapping("update")
    public ResponseEntity<String> UpdateMap(@RequestBody String gameId) {
        if (gameIdService.getGameIdList().contains(gameId)) {
            ChessGame chessGame =  gameIdService.getGameList().get(gameId);
            return ResponseEntity.ok(chessGame.getMap());
        } else {
            return ResponseEntity.ok("Error");
        }
    }

    @PostMapping("get-player-to-play")
    public ResponseEntity<Integer> getGameStatus(@RequestBody String gameId) {
        if (gameIdService.getGameIdList().contains(gameId)) {
            ChessGame chessGame =  gameIdService.getGameList().get(gameId);
            return ResponseEntity.ok(chessGame.getPlayerToPlay());
        }
        return ResponseEntity.ok(-1);
    }

    @PostMapping("join")
    public ResponseEntity<Integer> JoinGame(@RequestBody GameJoinRequest gameJoinRequest) {
        String gameId = gameJoinRequest.getGameId();
        String player2Ip = gameJoinRequest.getPlayer2Ip();

        if (gameIdService.getGameIdList().contains(gameId)) {
            ChessGame chessGame =  gameIdService.getGameList().get(gameId);
            chessGame.setPlayer2Ip(player2Ip);
            if (chessGame.gameIsComplete())
                chessGame.start();
            return ResponseEntity.ok(0);
        } else {
            return ResponseEntity.ok(1);
        }
    }
}
