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
    public void shouldReturnNumberForSimpleValue(RomanNumeral romanValue, int number) {
        //given
        RomanConverter romanConverter = new RomanConverter();
        //when and then
        Assertions.assertEquals(number, romanConverter.convert(romanValue));

    }
    
    @Test
    public void shouldGiveAnErrorWithWrongRomanNumber() {
    	RomanNumeral input = null;
    	
    	RomanConverter romanConverter = new RomanConverter();
    	
    	Assertions.assertThrows(RuntimeException.class, ()-> romanConverter.convert(input));
    }
}
