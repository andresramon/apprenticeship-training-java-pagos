public class Leapyear {

    public boolean isMultipleOf(int year, int number) {
        return year % number == 0;
    }

    public boolean isLeap(int year) {
        boolean isMultipleOfFourHundred = isMultipleOf(year, 400);
        boolean isMultipleOfFourButNotByOneHundred = isMultipleOf(year, 4) &&
                !isMultipleOf(year, 100);
        return isMultipleOfFourHundred || isMultipleOfFourButNotByOneHundred;
    }
}
