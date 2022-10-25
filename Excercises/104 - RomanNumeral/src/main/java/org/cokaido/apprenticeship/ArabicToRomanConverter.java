package org.cokaido.apprenticeship;

public class ArabicToRomanConverter {
    public String convert(int arabicNumber) {
        return RomanNumeral.fromArabicNumeral(arabicNumber).name();
    }
}
