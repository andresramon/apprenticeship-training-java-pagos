package org.cokaido.apprenticeship;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    public void getFizzBuzzShouldThrowErrorWhenNumberIsBelowOrEqualsToZero(){
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when & then
        Assertions.assertThrows(RuntimeException.class,()-> fizzBuzz.getFizzBuzz(0));
        Assertions.assertThrows(RuntimeException.class,()-> fizzBuzz.getFizzBuzz(-10));
    }


    @Test
    public void getFizzBuzzReturnNumbers(){
        //given
        int numberToTest = 1;
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when & then
        Assertions.assertEquals(String.valueOf(numberToTest),fizzBuzz.getFizzBuzz(numberToTest));
    }
}