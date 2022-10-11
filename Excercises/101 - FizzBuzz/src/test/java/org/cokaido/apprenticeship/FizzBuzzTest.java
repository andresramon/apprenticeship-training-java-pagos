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
    }


}