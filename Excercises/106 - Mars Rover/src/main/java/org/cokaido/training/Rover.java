package org.cokaido.training;

public class Rover{
    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        if (isFacingEast(initialPosition[2])) {
            final int nextPosition = Integer.parseInt(initialPosition[0]) + 1;
            return nextPosition+ " " + initialPosition[1] + " "+ initialPosition[2];
        }

        if (isFacingWest(initialPosition[2])) {
            final int nextPosition = Integer.parseInt(initialPosition[0]) - 1;
            return nextPosition+ " " + initialPosition[1] + " "+ initialPosition[2];
        }
        final int nextPosition = Integer.parseInt(initialPosition[1]) + 1;

        return initialPosition[0]+ " " + nextPosition + " "+ initialPosition[2];
    }

    private boolean isFacingWest(String facing) {
        return "O".equals(facing);
    }

    private boolean isFacingEast(String facing) {
        return "E".equals(facing);
    }
}
