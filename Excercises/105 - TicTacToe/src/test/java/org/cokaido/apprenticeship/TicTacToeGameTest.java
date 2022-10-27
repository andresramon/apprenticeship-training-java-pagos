package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicTacToeGameTest{

    private final Player PLAYER_O = new Player("O");
    private final TicTacToeGame game = new TicTacToeGame();

    @Test()
    void playerODontPlayFirst(){
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_O));
    }

}