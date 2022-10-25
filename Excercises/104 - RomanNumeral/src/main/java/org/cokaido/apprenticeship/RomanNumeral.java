package org.cokaido.apprenticeship;

import java.util.Arrays;

public enum RomanNumeral {
    M(1000), XM(900), D(500), CD(400), C(100), XC(90), L(50)
    , XL(40), X(10), IX(9), V(5),IV(4), I(1);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
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
