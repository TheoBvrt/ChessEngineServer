package ch.bouverat.chessengineapi.chessengineapi.service;

public class GameStatusRequest {
    private String playerUuid;
    private String gameId;

    public String getPlayerUuid() {
        return playerUuid;
    }

    public String getGameId() {
        return gameId;
    }
}
