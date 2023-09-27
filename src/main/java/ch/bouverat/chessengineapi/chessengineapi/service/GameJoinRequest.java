package ch.bouverat.chessengineapi.chessengineapi.service;

public class GameJoinRequest {
    private String gameId;
    private String player2Ip;

    public String getGameId() {
        return gameId;
    }

    public String getPlayer2Ip() {
        return player2Ip;
    }
}
