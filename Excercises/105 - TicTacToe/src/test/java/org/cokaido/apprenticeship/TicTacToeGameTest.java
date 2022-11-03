package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    public void gameIsDrawAfterNinePlays() throws InvalidOperationException, GameOverException {
        game.play(PLAYER_X, new Position(1,1));
        game.play(PLAYER_O, new Position(1,2));
        game.play(PLAYER_X, new Position(1,3));
        game.play(PLAYER_O, new Position(2,1));
        game.play(PLAYER_X, new Position(2,2));
        game.play(PLAYER_O, new Position(2,3));
        game.play(PLAYER_X, new Position(3,1));
        game.play(PLAYER_O, new Position(3,2));
        game.play(PLAYER_X, new Position(3,3));
        Assertions.assertThrows(GameOverException.class, () -> game.play(PLAYER_O, new Position(4,4)));
    }

    @Test
    public void twoPlayersNotPlaysInSamePlace() throws InvalidOperationException, GameOverException {
        Position position = new Position(1,1);
        game.play(PLAYER_X, position);
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_O, position));

    }
}