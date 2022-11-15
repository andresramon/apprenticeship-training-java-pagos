package org.cokaido.training;

import java.util.StringJoiner;

public class Rover{

    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        String[] finalPosition = calculatePosition(initialPosition);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String position : finalPosition) {
            stringJoiner.add(position);
        }
        return stringJoiner.toString();
    }

    private String[] calculatePosition(String[] initialPosition) {
        CardinalPoints cardinalPoint = CardinalPoints.valueOf(initialPosition[2]);
        final int nextPositionX = Integer.parseInt(initialPosition[0]) + cardinalPoint.getXAxis();
        final int nextPositionY = Integer.parseInt(initialPosition[1]) + cardinalPoint.getYAxis();
        return new String[]{String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
    }


}
