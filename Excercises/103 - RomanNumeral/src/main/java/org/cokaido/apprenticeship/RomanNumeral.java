package org.cokaido.apprenticeship;

public enum RomanNumeral {
    I, V, X, L, C, D, M;

    public static int getValue(final RomanNumeral romanNumeral){
        switch (romanNumeral) {
        case I : return 1;
        case V: return 5;
        case X: return 10;
        case L: return 50;
        case C: return 100;
        case D: return 500;
        case M: return 1000;
        default:
            return 0;
        }
    }
}
