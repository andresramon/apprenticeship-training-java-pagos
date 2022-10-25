package org.cokaido.apprenticeship;

import java.util.Arrays;

public enum RomanNumeral {
    I(1), II(2), III(3),IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), XM(900), M(1000);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }

    public static RomanNumeral fromArabicNumeral(int arabicNumeral) {
        return Arrays.stream(values()).filter(romanNumeral -> romanNumeral.value == arabicNumeral).findFirst().
                orElse(null);
    }

    public static int getValue(RomanNumeral romanNumeral) {
        return romanNumeral.getValue();
    }

}
