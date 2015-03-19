package Madness.model;

import java.util.List;

public class GameSchedule {
    private String date;
    private List<GameInfo> games;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<GameInfo> getGames() {
        return games;
    }

    public void setGames(List<GameInfo> games) {
        this.games = games;
    }
}
