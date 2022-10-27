package org.cokaido.apprenticeship;

public class TicTacToeGame{

    private final Player playerX = new Player("X");
    private final Player playerO = new Player("O");
    private Player currentPlayer;

    public TicTacToeGame(){
        this.currentPlayer = playerX;
    }

    public void play(final Player player) throws InvalidOperationException{
        if(!player.equals(currentPlayer)){
            throw new InvalidOperationException();
        }
        // TODO play logic
        currentPlayer = (currentPlayer.equals(playerX)) ? playerO : playerX;
    }
}
