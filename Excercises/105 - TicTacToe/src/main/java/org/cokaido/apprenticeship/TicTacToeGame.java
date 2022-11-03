package org.cokaido.apprenticeship;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame{

    public enum PositionType {
        TOP_LEFT, TOP_CENTER, TOP_RIGHT,
        CENTER_LEFT, CENTER, CENTER_RIGHT,
        BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
    }
    private final Player playerX = new Player("X");
    private final Player playerO = new Player("O");
    private Player currentPlayer;

    private int countDown;
    private List<PositionType> playersPositionList;

    public TicTacToeGame(){
        this.currentPlayer = playerX;
        this.countDown = 9;
        this.playersPositionList = new ArrayList<>();
    }

    public void play(final Player player) throws InvalidOperationException, GameOverException {
        // TODO pending refactor
        play(player, null);
    }

    public void play(final Player player, final PositionType position) throws InvalidOperationException, GameOverException {
        checkGameOver();

        checkValidPlayer(player);
        checkValidPosition(position);
        // TODO play logic
        playersPositionList.add(position);
        changePlayerTurn();
        countDown--;
    }

    private void checkValidPosition(PositionType position) throws InvalidOperationException {
        if (playersPositionList.contains(position)) {
            throw new InvalidOperationException();
        }
    }

    private void checkGameOver() throws GameOverException {
        if (countDown == 0) {
            throw new GameOverException();
        }
    }

    private void changePlayerTurn() {
        currentPlayer = (currentPlayer.equals(playerX)) ? playerO : playerX;
    }

    private void checkValidPlayer(Player player) throws InvalidOperationException {
        if(!player.equals(currentPlayer)){
            throw new InvalidOperationException();
        }
    }
}
