package ch.bouverat.chessengineapi.chessengineapi.model;

public class ChessGame {
    private final String gameId;
    private String player1Ip;
    private String player2Ip;

    public ChessGame (String gameId) {
        this.gameId = gameId;
    }

    public void start () {
    }

    public void setPlayer1Ip(String id) {
        player1Ip = id;
    }

    public void setPlayer2Ip(String id) {
        player2Ip = id;
    }

    public void printPlayerIp() {
        System.out.println("Player 1 " + player1Ip);
        System.out.println("Player 2 " + player2Ip);

    }
}
