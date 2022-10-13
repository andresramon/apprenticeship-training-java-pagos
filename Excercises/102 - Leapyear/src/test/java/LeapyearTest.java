import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LeapyearTest {

    private static final Leapyear leapyear = new Leapyear();

    @ParameterizedTest
    @ValueSource(ints = {400, 800, 1200})
    public void shouldBeLeapYearIfIsDivisibleByFourHundred(int year) {
        //given

        // when
        boolean isLeap = leapyear.isLeap(year);
        // then
        Assertions.assertTrue(isLeap);

    }

}
