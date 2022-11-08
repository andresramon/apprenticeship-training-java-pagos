package org.cokaido.apprenticeship;

import java.util.HashMap;
import java.util.Map;

public class GamePlays{
    protected Map<PositionType, Player> plays;

    private PositionType[][] winnerPlays;

    public GamePlays(){
        this.plays = new HashMap<>();
        winnerPlays = new PositionType[][] {{PositionType.TOP_LEFT, PositionType.TOP_CENTER, PositionType.TOP_RIGHT},
                {PositionType.CENTER_LEFT, PositionType.CENTER, PositionType.CENTER_RIGHT},
                {PositionType.BOTTOM_LEFT, PositionType.BOTTOM_CENTER, PositionType.BOTTOM_RIGHT},
                {PositionType.TOP_LEFT, PositionType.CENTER_LEFT, PositionType.BOTTOM_LEFT},
                {PositionType.TOP_CENTER, PositionType.CENTER, PositionType.BOTTOM_CENTER},
                {PositionType.TOP_RIGHT, PositionType.CENTER_RIGHT, PositionType.BOTTOM_RIGHT}};
    }

    public void takePosition(PositionType position, Player player) throws InvalidOperationException, GameOverException{
        checkGameOver();
        checkValidPosition(position);
        plays.put(position, player);
    }

    private void checkGameOver() throws GameOverException{
        if(plays.size() == 9 || isWinnerCombination()){
            throw new GameOverException();
        }
    }

    private boolean isWinnerCombination(){
        for(int index = 0; index < winnerPlays.length; index++){
            if (isPositionsArePlayed(index) && isPositionsPlayedByTheSamePlayer(index)){
                return true;
            }
        }
        return false;
    }

    private boolean isPositionsPlayedByTheSamePlayer(int index){
        return plays.get(winnerPlays[index][0]).equals(plays.get(winnerPlays[index][1])) && plays.get(
                winnerPlays[index][1]).equals(plays.get(winnerPlays[index][2]));
    }

    private boolean isPositionsArePlayed(int index){
        return plays.containsKey(winnerPlays[index][0]) && plays.containsKey(winnerPlays[index][1])
                && plays.containsKey(winnerPlays[index][2]);
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
