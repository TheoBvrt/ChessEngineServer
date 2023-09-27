package ch.bouverat.chessengineapi.chessengineapi.model;

public class ChessGame {
    private final String gameId;
    private String[] playerId;

    public ChessGame (String gameId) {
        this.gameId = gameId;
    }
}
