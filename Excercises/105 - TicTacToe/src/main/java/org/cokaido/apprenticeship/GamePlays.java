package org.cokaido.apprenticeship;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class GamePlays{
    private final WinnerPlays winnerPlays = new WinnerPlays();
    protected Map<PositionType, Player> plays;

    public GamePlays(){
        this.plays = new HashMap<>();
    }

    public void takePosition(PositionType position, Player player) throws InvalidOperationException, GameOverException{
        checkGameOver();
        checkValidPosition(position);
        plays.put(position, player);
    }

    private void checkGameOver() throws GameOverException{
        if(plays.size() == 9 || existsWinnerCombination()){
            throw new GameOverException();
        }
    }

    private boolean existsWinnerCombination(){
        return Stream.of(winnerPlays.getWinnerPlays()).anyMatch(this::isWinnerCombination);
    }

    private boolean isWinnerCombination(PositionType[] combination) {
        return isPositionsArePlayed(combination) && isPositionsPlayedByTheSamePlayer(combination);
    }

    private boolean isPositionsPlayedByTheSamePlayer(PositionType[] combination){
        return plays.get(combination[0]).equals(plays.get(combination[1])) && plays.get(
                combination[1]).equals(plays.get(combination[2]));
    }

    private boolean isPositionsArePlayed(PositionType[] combination){
        return plays.containsKey(combination[0]) && plays.containsKey(combination[1])
                && plays.containsKey(combination[2]);
    }

    private boolean isPositionTaken(GamePlays.PositionType position){
        return plays.containsKey(position);
    }

    private void checkValidPosition(GamePlays.PositionType position) throws InvalidOperationException{
        if(position == null || isPositionTaken(position)){
            throw new InvalidOperationException();
        }
    }

    public enum PositionType{
        TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
    }
}
