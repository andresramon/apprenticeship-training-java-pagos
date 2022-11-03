package org.cokaido.apprenticeship;

import java.util.ArrayList;
import java.util.List;

public class GamePlays {
    protected List<PositionType> playersPositionList;

    public GamePlays() {
        this.playersPositionList = new ArrayList<>();
    }

    public void play(PositionType position) {
        playersPositionList.add(position);
    }

    public boolean isPositionTaken(GamePlays.PositionType position) {
        return playersPositionList.contains(position);
    }

    public enum PositionType {
        TOP_LEFT, TOP_CENTER, TOP_RIGHT,
        CENTER_LEFT, CENTER, CENTER_RIGHT,
        BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
    }
}
