package org.cokaido.apprenticeship;

public class TicTacToeGame{

    private String currentPlayer;

    public TicTacToeGame(){
        this.currentPlayer = "X";
    }

    public void play(final String player) throws InvalidOperationException{
        if(!player.equals(currentPlayer)){
            throw new InvalidOperationException();
        }
    }
}
