package ch.bouverat.chessengineapi.chessengineapi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChessGame {
    private final String gameId;
    private String player1Uuid;
    private String player2Uuid;
    private String map;

    private int playerToPlay; //0 : White team //1 : Black team

    public ChessGame (String gameId) {
        this.gameId = gameId;
    }

    public void start () {
        playerToPlay = 0;
    }

    public void createMap() {
        String[][] startingMap = new String[8][8];

        startingMap[0][0] = "BR1";
        startingMap[0][1] = "BKT1";
        startingMap[0][2] = "BB2";
        startingMap[0][3] = "BQ";
        startingMap[0][4] = "BK";
        startingMap[0][5] = "BB2";
        startingMap[0][6] = "BKT2";
        startingMap[0][7] = "BR2";

        startingMap[7][0] = "WR1";
        startingMap[7][1] = "WKT1";
        startingMap[7][2] = "WB1";
        startingMap[7][3] = "WQ";
        startingMap[7][4] = "WK";
        startingMap[7][5] = "WB2";
        startingMap[7][6] = "WKT2";
        startingMap[7][7] = "WR2";
        for (int i = 0; i < 8; i++) {
            startingMap[1][i] = "BP" + (i + 1);
        }
        for (int i = 0; i < 8; i++) {
            startingMap[6][i] = "WP" + (i + 1);
        }
        for (int y = 2; y < 6; y++) {
            for (int x = 0; x < 8; x++) {
                startingMap[y][x] = "000";
            }
        }

        Gson gson = new GsonBuilder().create();
        map = gson.toJson(startingMap);
    }

    public void setPlayer1Ip(String id) {
        player1Uuid = id;
    }

    public void setPlayer2Ip(String id) {
        player2Uuid = id;
    }

    public void setPlayerToPlay(int player) {
        playerToPlay = player;
    }

    public int getPlayerToPlay() {
        return playerToPlay;
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
