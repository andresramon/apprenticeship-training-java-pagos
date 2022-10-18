public class Leapyear {

    public boolean isMultipleOf(int year, int number) {
        return year % number == 0;
    }

    public boolean isLeap(int year) {
        if (isMultipleOf(year, 400)) {
            return true;
        }
        return isMultipleOf(year, 4) &&
                !isMultipleOf(year, 100);
    }
}
