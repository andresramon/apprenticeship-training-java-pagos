package org.cokaido.training;

public class Rover{
    public String execute(String command){
        final String[] splitCommand = command.split("\n");
        final String[] initialPosition = splitCommand[1].split(" ");

        final int nextPosition = Integer.parseInt(initialPosition[1]) + 1;

        return initialPosition[0]+ " " + nextPosition + " N";
    }
}
