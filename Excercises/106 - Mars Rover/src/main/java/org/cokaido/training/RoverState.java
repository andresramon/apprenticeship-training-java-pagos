package org.cokaido.training;

public class RoverState {

    private final Position position;
    private final Orientation orientation;

    public RoverState(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public String[] calculatePosition(boolean forward) {
        CardinalPoints cardinalPoint = CardinalPoints.valueOf(orientation.getValue());
        if(forward){
            return moveForward(cardinalPoint);
        }
        return moveBackward(cardinalPoint);
    }

    private String[] moveBackward(CardinalPoints cardinalPoint) {
        final int nextPositionX = position.getXAxis() - cardinalPoint.getXAxis();
        final int nextPositionY = position.getYAxis() - cardinalPoint.getYAxis();
        return new String[] {String.valueOf(nextPositionX), String.valueOf(nextPositionY), orientation.getValue()};
    }

    private String[] moveForward(CardinalPoints cardinalPoint) {
        final int nextPositionX = position.getXAxis() + cardinalPoint.getXAxis();
        final int nextPositionY = position.getYAxis() + cardinalPoint.getYAxis();
        return new String[] {String.valueOf(nextPositionX), String.valueOf(nextPositionY), orientation.getValue()};
    }
}
