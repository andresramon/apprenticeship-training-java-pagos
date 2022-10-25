package org.cokaido.apprenticeship;

public class ArabicToRomanConverter {

    public String convert(int arabicNumber) {
        RomanNumeral romanNumeral = RomanNumeral.fromArabicNumeral(arabicNumber);
        if (romanNumeral != null) {
            return romanNumeral.name();
        }

        if (arabicNumber> 50) {
            return "L"+ convert(arabicNumber-50);
        }
        if (arabicNumber> 40) {
            return "XL"+ convert(arabicNumber-40);
        }
        if (arabicNumber> 10) {
            return "X"+ convert(arabicNumber-10);
        }

        return convert(arabicNumber-1) + "I";

    }
}
