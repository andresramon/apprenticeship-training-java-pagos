package org.cokaido.apprenticeship;

public class WinnerPlays {

    private final GamePlays.PositionType[][] winnerPlays;

    public WinnerPlays() {
        this.winnerPlays = new GamePlays.PositionType[][]{{GamePlays.PositionType.TOP_LEFT, GamePlays.PositionType.TOP_CENTER, GamePlays.PositionType.TOP_RIGHT},
                {GamePlays.PositionType.CENTER_LEFT, GamePlays.PositionType.CENTER, GamePlays.PositionType.CENTER_RIGHT},
                {GamePlays.PositionType.BOTTOM_LEFT, GamePlays.PositionType.BOTTOM_CENTER, GamePlays.PositionType.BOTTOM_RIGHT},
                {GamePlays.PositionType.TOP_LEFT, GamePlays.PositionType.CENTER_LEFT, GamePlays.PositionType.BOTTOM_LEFT},
                {GamePlays.PositionType.TOP_CENTER, GamePlays.PositionType.CENTER, GamePlays.PositionType.BOTTOM_CENTER},
                {GamePlays.PositionType.TOP_RIGHT, GamePlays.PositionType.CENTER_RIGHT, GamePlays.PositionType.BOTTOM_RIGHT}};
    }

    public GamePlays.PositionType[][] getWinnerPlays() {
        return winnerPlays;
    }
}