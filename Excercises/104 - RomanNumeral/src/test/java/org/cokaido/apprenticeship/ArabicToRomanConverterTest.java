package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArabicToRomanConverterTest {

    public static Stream<Arguments> argumentsToConvertRoman() {
        return Stream.of(
                Arguments.of(1,"I"),
                Arguments.of(2,"II"),
                Arguments.of(3,"III"),
                Arguments.of(4, "IV"),
                Arguments.of(8, "VIII"),
                Arguments.of(11, "XI"),
                Arguments.of(14, "XIV"),
                Arguments.of(39, "XXXIX"),
                Arguments.of(40, "XL"),
                Arguments.of(41, "XLI")
               //, Arguments.of(59, "LIX")
        );

    }

    @ParameterizedTest
    @MethodSource("argumentsToConvertRoman")
    public void shouldCovertArabicToRoman(int arabic, String roman) {
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        Assertions.assertEquals(converter.convert(arabic), roman);

    }

}
