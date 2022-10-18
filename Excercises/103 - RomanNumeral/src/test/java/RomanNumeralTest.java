import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanNumeralTest {

    private static Stream<Arguments> romanSimpleValues() {
        return Stream.of(
                Arguments.of(RomanValues.I, 1),
                Arguments.of(RomanValues.V, 5),
                Arguments.of(RomanValues.X, 10)
                );
    }

    @ParameterizedTest
    @MethodSource("romanSimpleValues")
    public void shouldReturnNumberForSimpleValue(RomanValues romanValue, int number) {
        //given
        RomanNumeral romanNumeral = new RomanNumeral();
        //when and then
        Assertions.assertEquals(number, romanNumeral.convert(romanValue));

    }
}
