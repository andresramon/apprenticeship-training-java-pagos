package org.cokaido.training;

import java.util.StringJoiner;

public class Rover{

    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        if(splitCommand[2].equals("A")) {
            String[] finalPosition = calculatePosition(initialPosition);
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (String position : finalPosition) {
                stringJoiner.add(position);
            }
            return stringJoiner.toString();
        }
        if(splitCommand[2].equals("I")) {
            String[] finalPosition = rotateLeft(initialPosition);
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (String position : finalPosition) {
                stringJoiner.add(position);
            }
            return stringJoiner.toString();
        }
        return "";
    }

    private String[] rotateLeft(String[] initialPosition) {
        return new String[]{initialPosition[0], initialPosition[1], getLeftOrientation(initialPosition[2])};
    }

    private String getLeftOrientation(String orientation) {
        if(orientation.equals("N")) {
            return "O";
        }

        return "S";
    }

    private String[] calculatePosition(String[] initialPosition) {
        CardinalPoints cardinalPoint = CardinalPoints.valueOf(initialPosition[2]);
        final int nextPositionX = Integer.parseInt(initialPosition[0]) + cardinalPoint.getXAxis();
        final int nextPositionY = Integer.parseInt(initialPosition[1]) + cardinalPoint.getYAxis();
        return new String[]{String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
    }


}
