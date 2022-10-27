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
    public void playerShouldNotPlayTwiceInRow() throws InvalidOperationException {
        game.play(PLAYER_X);
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_X));
    }
}