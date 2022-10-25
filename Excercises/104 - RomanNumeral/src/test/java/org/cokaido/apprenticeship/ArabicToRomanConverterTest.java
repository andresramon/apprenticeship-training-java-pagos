package org.cokaido.apprenticeship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArabicToRomanConverterTest {

    @Test
    public void shouldConvertOneToI(){
        // given
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        Assertions.assertEquals(converter.convert(1), "I");
    }

    @Test
    public void shouldConvertTwoToII() {
        // given
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        Assertions.assertEquals(converter.convert(2), "II");

    }

}
