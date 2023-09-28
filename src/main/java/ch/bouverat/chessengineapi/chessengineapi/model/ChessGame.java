package ch.bouverat.chessengineapi.chessengineapi.model;

public class ChessGame {
    private final String gameId;
    private String player1Uuid;
    private String player2Uuid;
    private String map;

    public ChessGame (String gameId) {
        this.gameId = gameId;
    }

    public void start () {
        System.out.println("Game " + gameId + " started !");
    }

    public void setPlayer1Ip(String id) {
        player1Uuid = id;
    }

    public void setPlayer2Ip(String id) {
        player2Uuid = id;
    }

    public void printPlayerIp() {
        System.out.println("Player 1 " + player1Uuid);
        System.out.println("Player 2 " + player2Uuid);
    }

    public void updateMap(String jsonMap) {
        map = jsonMap;
    }

    public String getMap() {
        return (map);
    }
    public boolean gameIsComplete () {
        return player1Uuid != null && player2Uuid != null;
    }
}
