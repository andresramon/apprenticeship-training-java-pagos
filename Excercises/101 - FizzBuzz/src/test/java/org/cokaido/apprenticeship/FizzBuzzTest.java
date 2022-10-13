package org.cokaido.apprenticeship;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
    

    @ParameterizedTest @ValueSource(ints = {3, 6, 9, 12})
    public void getFizzBuzzReturnFizz(int input){
        // given
        FizzBuzz fizzBuzz = new FizzBuzz();

        Assertions.assertEquals(FIZZ, fizzBuzz.getFizzBuzz(input));
    }





}