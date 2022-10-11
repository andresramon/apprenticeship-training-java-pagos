package org.cokaido.apprenticeship;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void return1whenNumberIs1() {

        String result = new FizzBuzz().getFizzBuzz(1);
        String expectedResult="Fizz";
        Assertions.assertEquals(expectedResult,result);
    }
}