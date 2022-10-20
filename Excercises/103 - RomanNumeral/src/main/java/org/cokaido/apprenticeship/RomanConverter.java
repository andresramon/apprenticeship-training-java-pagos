package org.cokaido.apprenticeship;

public class RomanConverter {

    public int convert(String romanValue) throws InvalidRomanNumeralException{
        checkValidRomanValue(romanValue);
        return romanValue.chars().
                mapToObj(c -> (char) c).mapToInt(character ->
                        RomanNumeral.getValue(RomanNumeral.valueOf(character.toString()))).
                sum();
    }

    private void checkValidRomanValue(String romanValue) throws InvalidRomanNumeralException {
        if(romanValue == null){
            throw new InvalidRomanNumeralException();
        }
        int count = 1;
        char[] characters = romanValue.toCharArray();
        for (int index = 0; index < characters.length; index++) {
            if (index > 0) {
                if (characters[index - 1] == characters[index]) {
                    count++;
                } else {
                    count = 1;
                }
            }
            if (count>3) {
                throw new InvalidRomanNumeralException();
            }
        }
    }
}
