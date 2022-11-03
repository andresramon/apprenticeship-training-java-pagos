package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TicTacToeGameTest{

    private final Player PLAYER_O = new Player("O");
    private final Player PLAYER_X = new Player("X");
    private TicTacToeGame game;

    @BeforeEach
    public void startUp() {
        game = new TicTacToeGame();
    }

    @Test
    public void playerODontPlayFirst(){
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_O));
    }

    @Test
    public void playerShouldNotPlayTwiceInRow() throws InvalidOperationException, GameOverException {
        game.play(PLAYER_X);
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_X));
    }

    @Test
    @Disabled
    public void gameIsDrawAfterNinePlays() throws InvalidOperationException, GameOverException {
        game.play(PLAYER_X, TicTacToeGame.PositionType.TOP_LEFT);
        game.play(PLAYER_O, TicTacToeGame.PositionType.TOP_CENTER);
        game.play(PLAYER_X, TicTacToeGame.PositionType.TOP_RIGHT);
        game.play(PLAYER_O, TicTacToeGame.PositionType.CENTER_LEFT);
        game.play(PLAYER_X, TicTacToeGame.PositionType.CENTER);
        game.play(PLAYER_O, TicTacToeGame.PositionType.CENTER_RIGHT);
        game.play(PLAYER_X, TicTacToeGame.PositionType.BOTTOM_LEFT);
        game.play(PLAYER_O, TicTacToeGame.PositionType.BOTTOM_CENTER);
        game.play(PLAYER_X, TicTacToeGame.PositionType.BOTTOM_RIGHT);
        //TODO review When game is draw
        Assertions.assertThrows(GameOverException.class, () -> game.play(PLAYER_O, null));
    }

    @Test
    public void twoPlayersNotPlaysInSamePlace() throws InvalidOperationException, GameOverException {
        TicTacToeGame.PositionType position = TicTacToeGame.PositionType.TOP_LEFT;
        game.play(PLAYER_X, position);
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_O, position));

    }
}