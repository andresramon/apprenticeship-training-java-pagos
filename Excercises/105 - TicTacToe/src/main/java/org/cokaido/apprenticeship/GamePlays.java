package org.cokaido.apprenticeship;

import java.util.ArrayList;
import java.util.List;

public class GamePlays {
    protected List<PositionType> playersPositionList;

    public GamePlays() {
        this.playersPositionList = new ArrayList<>();
    }

    public void takePosition(PositionType position) throws InvalidOperationException {
        checkValidPosition(position);
        playersPositionList.add(position);
    }

    private boolean isPositionTaken(GamePlays.PositionType position) {
        return playersPositionList.contains(position);
    }

    private void checkValidPosition(GamePlays.PositionType position) throws InvalidOperationException {
        if (isPositionTaken(position)) {
            throw new InvalidOperationException();
        }
    }

    public enum PositionType {
        TOP_LEFT, TOP_CENTER, TOP_RIGHT,
        CENTER_LEFT, CENTER, CENTER_RIGHT,
        BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
    }
}
