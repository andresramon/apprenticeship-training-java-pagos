package org.cokaido.apprenticeship;

public class TicTacToeGame  {

    private static final Player playerX = new Player("X");
    private static final Player playerO = new Player("O");
    private Player currentPlayer;
    private final GamePlays gamePlays;

    public TicTacToeGame(){
        super();
        this.currentPlayer = playerX;
        this.gamePlays = new GamePlays();
    }

    public void play(final Player player, final GamePlays.PositionType position) throws InvalidOperationException, GameOverException, InvalidPlayerException {
        checkValidPlayer(player);
        gamePlays.takePosition(position, player);
        changePlayerTurn();
    }

    private void changePlayerTurn() {
        currentPlayer = (currentPlayer.equals(playerX)) ? playerO : playerX;
    }

    private void checkValidPlayer(Player player) throws InvalidPlayerException {
        if(!player.equals(currentPlayer)){
            throw new InvalidPlayerException();
        }
    }
}
