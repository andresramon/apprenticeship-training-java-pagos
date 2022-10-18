import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanConverterTest {

    private static Stream<Arguments> romanSimpleValues() {
        return Stream.of(
                Arguments.of(RomanNumeral.I, 1),
                Arguments.of(RomanNumeral.V, 5),
                Arguments.of(RomanNumeral.X, 10)
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
}
