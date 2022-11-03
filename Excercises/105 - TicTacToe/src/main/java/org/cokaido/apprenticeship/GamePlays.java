package org.cokaido.apprenticeship;

import java.util.HashMap;
import java.util.Map;

public class GamePlays {
    protected Map<PositionType, Player> plays;

    public GamePlays() {
        this.plays = new HashMap<>();
    }

    public void takePosition(PositionType position, Player player) throws InvalidOperationException, GameOverException {
        checkGameOver();
        checkValidPosition(position);
        plays.put(position, player);
    }

    private void checkGameOver() throws GameOverException {
        if (plays.size() == 9 || isRowTakenByPlayer()) {
            throw new GameOverException();
        }
    }

    private boolean isRowTakenByPlayer(){
        //TODO: Sara sigue
        return false;
    }

    private boolean isPositionTaken(GamePlays.PositionType position) {
        return plays.containsKey(position);
    }

    private void checkValidPosition(GamePlays.PositionType position) throws InvalidOperationException {
        if (position == null || isPositionTaken(position)) {
            throw new InvalidOperationException();
        }
    }

    public enum PositionType {
        TOP_LEFT, TOP_CENTER, TOP_RIGHT,
        CENTER_LEFT, CENTER, CENTER_RIGHT,
        BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
    }
}
