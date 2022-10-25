package org.cokaido.apprenticeship;

public class ArabicToRomanConverter {

    public String convert(int arabicNumber) {

        RomanNumeral romanNumeral = RomanNumeral.fromArabicNumeral(arabicNumber);
        if (romanNumeral != null) {
            return romanNumeral.name();
        }
        return "I" + convert(arabicNumber-1);

    }
}
