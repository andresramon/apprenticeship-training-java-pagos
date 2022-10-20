package org.cokaido.apprenticeship;

public class RomanConverter {

    public int convert(String romanValue) throws InvalidRomanNumeralException{
        if(romanValue == null){
            throw new InvalidRomanNumeralException();
        }
        return romanValue.chars().
                mapToObj(c -> (char) c).mapToInt(character ->
                        RomanNumeral.getValue(RomanNumeral.valueOf(character.toString()))).
                sum();
    }
}
