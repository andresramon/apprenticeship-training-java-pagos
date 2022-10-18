public class RomanConverter {
    public int convert(RomanNumeral romanValue) {
        switch (romanValue) {
            case I : return 1;
            case V: return 5;
            case X: return 10;
            case L:
            case C:
            case D:
            case M:
            default:
                return 0;
        }
    }
}
