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

    @ParameterizedTest
    @ValueSource(ints = {2008, 2012, 2016})
    public void shouldBeLeapYearIfIsDivisibleByFourButNotByOneHundred(int year) {
        //given

        // when
        boolean isLeap = leapyear.isLeap(year);
        // then
        Assertions.assertTrue(isLeap);

    }

    @ParameterizedTest
    @ValueSource(ints = {1700, 1800, 1900, 2017, 2018, 2019})
    public void shouldNotBeLeapYear(int year) {
        //given

        // when
        boolean isLeap = leapyear.isLeap(year);
        // then
        Assertions.assertFalse(isLeap);

    }

}
