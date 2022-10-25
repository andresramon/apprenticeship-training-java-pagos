package org.cokaido.apprenticeship;

public class ArabicToRomanConverter {

    public String convert(int arabicNumber) {
        RomanNumeral romanNumeral = RomanNumeral.fromArabicNumeral(arabicNumber);
        if (romanNumeral != null) {
            return romanNumeral.name();
        }
        for (RomanNumeral numeral : RomanNumeral.values()) {
            if (numeral.getValue() < arabicNumber) {
                return numeral.name() + convert(arabicNumber - numeral.getValue());
            }
        }
        return "";
    }
}
