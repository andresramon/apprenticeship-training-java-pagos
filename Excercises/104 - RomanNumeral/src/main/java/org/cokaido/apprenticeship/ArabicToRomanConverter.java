package org.cokaido.apprenticeship;

public class ArabicToRomanConverter {

    public String convert(int arabicNumber) {

        for (RomanNumeral romanNumeral: RomanNumeral.values()) {
            if (romanNumeral.getValue() <= arabicNumber) {
                return romanNumeral.name() + convert(arabicNumber - romanNumeral.getValue());
            }
        }
        return "";
    }
}
