package org.cokaido.training;

public class RoverState {

    private final Position position;
    private final Orientation orientation;

    public RoverState(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Position getPosition() {
        return position;
    }
}
