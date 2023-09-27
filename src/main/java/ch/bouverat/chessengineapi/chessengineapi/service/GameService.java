package ch.bouverat.chessengineapi.chessengineapi.service;

import ch.bouverat.chessengineapi.chessengineapi.model.ChessGame;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private List<String> gameIdList = new ArrayList<>();
    private Map<String, ChessGame> gameList = new HashMap<>();
    public static int id;

    public String generateUniqueId () {
        id ++;
        String uniqueId = "#" + id;
        gameIdList.add(uniqueId);
        return (uniqueId);
    }

    public void createGame(String gameId, String macAddress) {
        ChessGame newChessGame = new ChessGame(gameId);
        newChessGame.setPlayer1Ip(macAddress);
        newChessGame.printPlayerIp();
        gameList.put(gameId, newChessGame);
    }

    public Map<String, ChessGame> getGameList () {
        return gameList;
    }

    public List<String> getGameIdList () {
        return gameIdList;
    }
}
