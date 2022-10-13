import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapyearTest {

    @Test
    public void shouldBeLeapYearIfIsDivisibleByFourHundred() {
        //given
        Leapyear leapyear = new Leapyear();
        // when
        boolean isLeap = leapyear.isLeap(400);
        // then
        Assertions.assertTrue(isLeap);

    }

}
