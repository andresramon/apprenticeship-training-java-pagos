package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanConverterTest {

    private static Stream<Arguments> romanSimpleValues() {
        return Stream.of(
                Arguments.of(RomanNumeral.I, 1),
                Arguments.of(RomanNumeral.V, 5),
                Arguments.of(RomanNumeral.X, 10),
                Arguments.of(RomanNumeral.L, 50),
                Arguments.of(RomanNumeral.C, 100),
                Arguments.of(RomanNumeral.D, 500),
                Arguments.of(RomanNumeral.M, 1000)
                );
    }

    @ParameterizedTest
    @MethodSource("romanSimpleValues")
    public void shouldReturnNumberForSimpleValue(RomanNumeral romanValue, int number)
            throws InvalidRomanNumeralException{
        //given
        RomanConverter romanConverter = new RomanConverter();
        //when and then
        Assertions.assertEquals(number, romanConverter.convert(romanValue));

    }
    
    @Test
    public void shouldRaiseControlledErrorWithWrongRomanNumber() {
    	RomanNumeral input = null;
    	
    	RomanConverter romanConverter = new RomanConverter();
    	
    	Assertions.assertThrows(InvalidRomanNumeralException.class, ()-> romanConverter.convert(input));
    }

    @Test
    public void shouldReturnTwoWhenRomanNumberIsII() throws InvalidRomanNumeralException{
        //given
        RomanConverter romanConverter = new RomanConverter();

        Assertions.assertEquals(2, romanConverter.convert("II"));
    }

    @Test
    public void shouldReturnThreeWhenRomanNumberIsIII() throws InvalidRomanNumeralException{
        //given
        RomanConverter romanConverter = new RomanConverter();

        Assertions.assertEquals(3, romanConverter.convert("III"));
    }
}
