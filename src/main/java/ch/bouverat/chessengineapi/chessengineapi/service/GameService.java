package ch.bouverat.chessengineapi.chessengineapi.service;

import ch.bouverat.chessengineapi.chessengineapi.model.ChessGame;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private List<String> gameIds = new ArrayList<>();
    private Map<String, ChessGame> gameList = new HashMap<>();
    public static int id;

    public String generateUniqueId () {
        id ++;
        String uniqueId = "#" + id;
        gameIds.add(uniqueId);
        return (uniqueId);
    }

    public void createGame(String gameId) {
        ChessGame newChessGame = new ChessGame(gameId);
        gameList.put(gameId, newChessGame);
    }
}
