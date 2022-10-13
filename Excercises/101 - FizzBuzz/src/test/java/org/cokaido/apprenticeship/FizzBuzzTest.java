package org.cokaido.apprenticeship;


import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

class FizzBuzzTest {

	final String FIZZ = "Fizz";
	
    @Test
    public void getFizzBuzzShouldThrowErrorWhenNumberIsBelowOrEqualsToZero(){
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when & then
        Assertions.assertThrows(RuntimeException.class,()-> fizzBuzz.getFizzBuzz(0));
        Assertions.assertThrows(RuntimeException.class,()-> fizzBuzz.getFizzBuzz(-10));
    }


    private static Stream<Arguments> argumentsForReturnNumbers() {
    	return Stream.of(
    			Arguments.of(1, "1"),
    			Arguments.of(2, "2"),
    			Arguments.of(4, "4")
			);
    }
    
    @ParameterizedTest
    @MethodSource("argumentsForReturnNumbers")
    public void getFizzBuzzReturnNumbers(int input, String output){
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when & then
        Assertions.assertEquals(output, fizzBuzz.getFizzBuzz(input));
    }
    
    @Test
    public void getFizzBuzzReturnFizz() {
    	int inputNumberFizz = 3;
    	
    	// given
	    FizzBuzz fizzBuzz = new FizzBuzz();
	    
	    Assertions.assertEquals(FIZZ, fizzBuzz.getFizzBuzz(inputNumberFizz));
    }
}