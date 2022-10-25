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
                Arguments.of(4, "IV")
        );

    }

    @ParameterizedTest
    @MethodSource("argumentsToConvertRoman")
    public void shouldCovertArabicToRoman(int arabic, String roman) {
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        Assertions.assertEquals(converter.convert(arabic), roman);

    }

}
