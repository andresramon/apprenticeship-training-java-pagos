package org.cokaido.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RoverTest{

    private static Stream<Arguments> argumentsMoveForward(){
        return Stream.of(
                Arguments.of("5 5\n0 1 N\nA\n", "0 2 N"),
                Arguments.of("5 5\n0 2 N\nA\n", "0 3 N"),
                Arguments.of("5 5\n1 2 N\nA\n", "1 3 N"),
                Arguments.of("5 5\n1 2 E\nA\n", "2 2 E"),
                Arguments.of("5 5\n1 2 O\nA\n", "0 2 O"),
                Arguments.of("5 5\n1 2 S\nA\n", "1 1 S")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsMoveForward")
    public void shouldMoveForward(String command, String expectedPosition){
        final Rover rover = new Rover();

        String position = rover.execute(command);

        Assertions.assertEquals(expectedPosition, position);
    }

    private static Stream<Arguments> argumentsRotateLeft(){
        return Stream.of(
                Arguments.of("5 5\n0 1 N\nI\n", "0 1 O"),
                Arguments.of("5 5\n0 1 O\nI\n", "0 1 S"),
                Arguments.of("5 5\n0 1 S\nI\n", "0 1 E"),
                Arguments.of("5 5\n0 1 E\nI\n", "0 1 N")

        );
    }

    @ParameterizedTest
    @MethodSource("argumentsRotateLeft")
    public void shouldRotateToLeft(String command, String expectedPosition){
        final Rover rover = new Rover();

        String position = rover.execute(command);

        Assertions.assertEquals(expectedPosition, position);
    }

    private static Stream<Arguments> argumentsMoveBackward(){
        return Stream.of(
                Arguments.of("5 5\n0 1 N\nR\n", "0 0 N"),
                Arguments.of("5 5\n0 3 N\nR\n", "0 2 N"),
                Arguments.of("5 5\n1 3 N\nR\n", "1 2 N"),
                Arguments.of("5 5\n2 2 E\nR\n", "1 2 E"),
                Arguments.of("5 5\n0 2 O\nR\n", "1 2 O"),
                Arguments.of("5 5\n1 1 S\nR\n", "1 2 S")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsMoveBackward")
    public void shouldMoveBackward(String command, String expectedPosition){
        final Rover rover = new Rover();

        String position = rover.execute(command);

        Assertions.assertEquals(expectedPosition, position);
    }

    private static Stream<Arguments> argumentsRotateRight(){
        return Stream.of(
                Arguments.of("5 5\n0 1 N\nD\n", "0 1 E"),
                Arguments.of("5 5\n0 1 O\nD\n", "0 1 N"),
                Arguments.of("5 5\n0 1 S\nD\n", "0 1 O"),
                Arguments.of("5 5\n0 1 E\nD\n", "0 1 S")

        );
    }

    @ParameterizedTest
    @MethodSource("argumentsRotateRight")
    public void shouldRotateToRight(String command, String expectedPosition){
        final Rover rover = new Rover();

        String position = rover.execute(command);

        Assertions.assertEquals(expectedPosition, position);
    }

}
