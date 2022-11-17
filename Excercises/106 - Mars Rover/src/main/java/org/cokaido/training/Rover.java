package org.cokaido.training;

import java.util.StringJoiner;

public class Rover{

    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        if(splitCommand[2].equals("A")) {
            return formatPosition(calculatePosition(initialPosition, true));
        }
        if(splitCommand[2].equals("I")) {
            return formatPosition(rotateLeft(initialPosition));
        }
        if(splitCommand[2].equals("R")) {
            return formatPosition(calculatePosition(initialPosition, false));
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

    private String getLeftOrientation(String orientation) {
        if(orientation.equals("N")) {
            return "O";
        }
        if(orientation.equals("S")) {
            return "E";
        }
        if(orientation.equals("E")) {
            return "N";
        }
        return "S";
    }

    private String[] calculatePosition(String[] initialPosition, boolean forward) {
        CardinalPoints cardinalPoint = CardinalPoints.valueOf(initialPosition[2]);
        if(forward){
            final int nextPositionX = Integer.parseInt(initialPosition[0]) + cardinalPoint.getXAxis();
            final int nextPositionY = Integer.parseInt(initialPosition[1]) + cardinalPoint.getYAxis();
            return new String[] {String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
        }
        final int nextPositionX = Integer.parseInt(initialPosition[0]) - cardinalPoint.getXAxis();
        final int nextPositionY = Integer.parseInt(initialPosition[1]) - cardinalPoint.getYAxis();
        return new String[] {String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
    }


}
