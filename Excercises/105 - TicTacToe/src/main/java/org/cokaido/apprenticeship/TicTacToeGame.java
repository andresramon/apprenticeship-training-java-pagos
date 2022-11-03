package org.cokaido.apprenticeship;

public class TicTacToeGame  {

    private final Player playerX = new Player("X");
    private final Player playerO = new Player("O");
    private Player currentPlayer;

    private int countDown;

    private GamePlays gamePlays;

    public TicTacToeGame(){
        super();
        this.currentPlayer = playerX;
        this.countDown = 9;
        this.gamePlays = new GamePlays();
    }

    public void play(final Player player) throws InvalidOperationException, GameOverException {
        // TODO pending refactor
        play(player, null);
    }

    public void play(final Player player, final GamePlays.PositionType position) throws InvalidOperationException, GameOverException {
        checkGameOver();

        checkValidPlayer(player);
        checkValidPosition(position);
        // TODO play logic
        gamePlays.play(position);
        changePlayerTurn();
        countDown--;
    }

    private void checkValidPosition(GamePlays.PositionType position) throws InvalidOperationException {
        if (gamePlays.isPositionTaken(position)) {
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
