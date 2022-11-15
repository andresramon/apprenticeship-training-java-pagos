package org.cokaido.training;

public class Rover{

    public enum CardinalPoints{
        N, S, E, O
    }

    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        if (isFacing(CardinalPoints.E, initialPosition[2])) {
            final int nextPosition = Integer.parseInt(initialPosition[0]) + 1;
            return nextPosition+ " " + initialPosition[1] + " "+ initialPosition[2];
        }

        if (isFacing(CardinalPoints.O, initialPosition[2])) {
            final int nextPosition = Integer.parseInt(initialPosition[0]) - 1;
            return nextPosition+ " " + initialPosition[1] + " "+ initialPosition[2];
        }

        if (isFacing(CardinalPoints.S, initialPosition[2])) {
            final int nextPosition = Integer.parseInt(initialPosition[1]) - 1;
            return initialPosition[0]+ " " + nextPosition + " "+ initialPosition[2];
        }
        final int nextPosition = Integer.parseInt(initialPosition[1]) + 1;

        return initialPosition[0]+ " " + nextPosition + " "+ initialPosition[2];
    }

    private boolean isFacing(CardinalPoints cardinalPoints, String facing) {
        return cardinalPoints.name().equals(facing);
    }
}
