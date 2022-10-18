import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {

    @Test
    public void shouldReturnOne() {
        //given
        RomanNumeral romanNumeral = new RomanNumeral();
        //when and then
        Assertions.assertEquals(1, romanNumeral.convert("I"));

    }
}
