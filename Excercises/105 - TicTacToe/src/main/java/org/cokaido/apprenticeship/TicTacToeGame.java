package org.cokaido.apprenticeship;

public class TicTacToeGame{

    private final Player playerX = new Player("X");
    private final Player playerO = new Player("O");
    private Player currentPlayer;

    private int countDown;

    public TicTacToeGame(){
        this.currentPlayer = playerX;
        this.countDown = 9;
    }

    public void play(final Player player) throws InvalidOperationException, GameOverException {
        checkGameOver();

        checkValidPlayer(player);
        // TODO play logic
        changePlayerTurn();
        countDown--;
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
