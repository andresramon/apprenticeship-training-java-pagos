package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
        Assertions.assertThrows(InvalidPlayerException.class, () -> game.play(PLAYER_O, GamePlays.PositionType.TOP_LEFT));
    }

    @Test
    public void playNullPositionIsInvalid(){
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_X, null));
    }

    @Test
    public void playerShouldNotPlayTwiceInRow() throws InvalidOperationException, GameOverException, InvalidPlayerException {
        game.play(PLAYER_X, GamePlays.PositionType.TOP_LEFT);
        Assertions.assertThrows(InvalidPlayerException.class, () -> game.play(PLAYER_X, GamePlays.PositionType.TOP_CENTER));
    }

    @Test
    public void gameIsDrawAfterNinePlays() throws InvalidOperationException, GameOverException, InvalidPlayerException {
        game.play(PLAYER_X, GamePlays.PositionType.TOP_LEFT);
        game.play(PLAYER_O, GamePlays.PositionType.TOP_CENTER);
        game.play(PLAYER_X, GamePlays.PositionType.TOP_RIGHT);
        game.play(PLAYER_O, GamePlays.PositionType.CENTER_LEFT);
        game.play(PLAYER_X, GamePlays.PositionType.CENTER);
        game.play(PLAYER_O, GamePlays.PositionType.CENTER_RIGHT);
        game.play(PLAYER_X, GamePlays.PositionType.BOTTOM_LEFT);
        game.play(PLAYER_O, GamePlays.PositionType.BOTTOM_CENTER);
        game.play(PLAYER_X, GamePlays.PositionType.BOTTOM_RIGHT);
        //TODO review When game is draw
        Assertions.assertThrows(GameOverException.class, () -> game.play(PLAYER_O, null));
    }

    @Test
    public void twoPlayersNotPlaysInSamePlace() throws InvalidOperationException, GameOverException, InvalidPlayerException {
        GamePlays.PositionType position = GamePlays.PositionType.TOP_LEFT;
        game.play(PLAYER_X, position);
        Assertions.assertThrows(InvalidOperationException.class, () -> game.play(PLAYER_O, position));
    }

    public static Stream<Arguments> winnerRowCombinations() {
        return Stream.of(
                Arguments.of(List.of(GamePlays.PositionType.TOP_LEFT,
                        GamePlays.PositionType.CENTER_LEFT,
                        GamePlays.PositionType.TOP_CENTER,
                        GamePlays.PositionType.BOTTOM_CENTER,
                        GamePlays.PositionType.TOP_RIGHT)),
                Arguments.of(List.of(GamePlays.PositionType.CENTER_LEFT,
                        GamePlays.PositionType.TOP_LEFT,
                        GamePlays.PositionType.CENTER,
                        GamePlays.PositionType.BOTTOM_CENTER,
                        GamePlays.PositionType.CENTER_RIGHT)),
                Arguments.of(List.of(GamePlays.PositionType.BOTTOM_LEFT,
                        GamePlays.PositionType.CENTER_LEFT,
                        GamePlays.PositionType.BOTTOM_CENTER,
                        GamePlays.PositionType.TOP_CENTER,
                        GamePlays.PositionType.BOTTOM_RIGHT))
        );

    }

    @ParameterizedTest
    @MethodSource("winnerRowCombinations")
    public void gameShouldBeOverWhenRowHasBeenTakenByPlayer(List<GamePlays.PositionType> positionTypeList)
            throws InvalidPlayerException, InvalidOperationException, GameOverException{
        game.play(PLAYER_X, positionTypeList.get(0));
        game.play(PLAYER_O, positionTypeList.get(1));
        game.play(PLAYER_X, positionTypeList.get(2));
        game.play(PLAYER_O, positionTypeList.get(3));
        game.play(PLAYER_X, positionTypeList.get(4));
        Assertions.assertThrows(GameOverException.class, () -> game.play(PLAYER_O, GamePlays.PositionType.BOTTOM_RIGHT));
    }

}