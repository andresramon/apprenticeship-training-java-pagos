package org.cokaido.training;

import java.util.StringJoiner;

public class Rover{

    private static final String NORTH = "N";
    private static final String WEST = "O";
    private static final String EAST = "E";
    private static final String SOUTH = "S";
    private static final String FORWARD = "A";
    private static final String LEFT = "I";
    private static final String BACKWARD = "R";
    public static final String RIGHT = "D";

    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        if(splitCommand[2].equals(FORWARD)) {
            return formatPosition(calculatePosition(initialPosition, true));
        }
        if(splitCommand[2].equals(LEFT)) {
            return formatPosition(rotateLeft(initialPosition));
        }
        if(splitCommand[2].equals(BACKWARD)) {
            return formatPosition(calculatePosition(initialPosition, false));
        }
        if(splitCommand[2].equals(RIGHT)) {
            return formatPosition(rotateRight(initialPosition));
        }
        return "";
    }

    private static String formatPosition(String[] finalPosition){
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String position : finalPosition) {
            stringJoiner.add(position);
        }
        return stringJoiner.toString();
    }

    private String[] rotateLeft(String[] initialPosition) {
        return new String[]{initialPosition[0], initialPosition[1], getLeftOrientation(initialPosition[2])};
    }

    private String[] rotateRight(String[] initialPosition) {
        return new String[]{initialPosition[0], initialPosition[1], getRightOrientation(initialPosition[2])};
    }

    private String getRightOrientation(String orientation) {
        if (orientation.equals(NORTH)) {
            return EAST;
        }
        return null;
    }

    private String getLeftOrientation(String orientation) {
        if(orientation.equals(NORTH)) {
            return WEST;
        }
        if(orientation.equals(SOUTH)) {
            return EAST;
        }
        if(orientation.equals(EAST)) {
            return NORTH;
        }
        return SOUTH;
    }

    private String[] calculatePosition(String[] initialPosition, boolean forward) {
        CardinalPoints cardinalPoint = CardinalPoints.valueOf(initialPosition[2]);
        if(forward){
            return moveForward(initialPosition, cardinalPoint);
        }
        return moveBackward(initialPosition, cardinalPoint);
    }

    private String[] moveBackward(String[] initialPosition, CardinalPoints cardinalPoint) {
        final int nextPositionX = Integer.parseInt(initialPosition[0]) - cardinalPoint.getXAxis();
        final int nextPositionY = Integer.parseInt(initialPosition[1]) - cardinalPoint.getYAxis();
        return new String[] {String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
    }

    private String[] moveForward(String[] initialPosition, CardinalPoints cardinalPoint) {
        final int nextPositionX = Integer.parseInt(initialPosition[0]) + cardinalPoint.getXAxis();
        final int nextPositionY = Integer.parseInt(initialPosition[1]) + cardinalPoint.getYAxis();
        return new String[] {String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
    }


}
