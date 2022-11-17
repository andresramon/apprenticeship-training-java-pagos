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
            if(initialPosition[2].equals("N")){
                return initialPosition[0] + " " + initialPosition[1] + " " + "O";
            }

            if(initialPosition[2].equals("O")){
                return initialPosition[0] + " " + initialPosition[1] + " " + "S";
            }
        }
        return "";
    }

    private String[] calculatePosition(String[] initialPosition) {
        CardinalPoints cardinalPoint = CardinalPoints.valueOf(initialPosition[2]);
        final int nextPositionX = Integer.parseInt(initialPosition[0]) + cardinalPoint.getXAxis();
        final int nextPositionY = Integer.parseInt(initialPosition[1]) + cardinalPoint.getYAxis();
        return new String[]{String.valueOf(nextPositionX), String.valueOf(nextPositionY), initialPosition[2]};
    }


}
