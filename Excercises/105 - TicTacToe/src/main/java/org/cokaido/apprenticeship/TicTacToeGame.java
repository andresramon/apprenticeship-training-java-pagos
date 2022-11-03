package org.cokaido.apprenticeship;

public class TicTacToeGame  {

    private final Player playerX = new Player("X");
    private final Player playerO = new Player("O");
    private Player currentPlayer;
    private GamePlays gamePlays;

    public TicTacToeGame(){
        super();
        this.currentPlayer = playerX;
        this.gamePlays = new GamePlays();
    }

    public void play(final Player player, final GamePlays.PositionType position) throws InvalidOperationException, GameOverException, InvalidPlayerException {
        checkValidPlayer(player);
        // TODO play logic
        gamePlays.takePosition(position);
        changePlayerTurn();

    }

    private void changePlayerTurn() {
        currentPlayer = (currentPlayer.equals(playerX)) ? playerO : playerX;
    }

    private void checkValidPlayer(Player player) throws InvalidOperationException, InvalidPlayerException {
        if(!player.equals(currentPlayer)){
            throw new InvalidPlayerException();
        }
    }
}
