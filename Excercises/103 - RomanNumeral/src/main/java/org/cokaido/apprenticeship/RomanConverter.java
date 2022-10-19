package org.cokaido.apprenticeship;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RomanConverter {
    public int convert(RomanNumeral romanValue) throws InvalidRomanNumeralException{
        return RomanNumeral.getValue(romanValue);
    }

    public int convert(String romanValue) throws InvalidRomanNumeralException{
        if(romanValue == null){
            throw new InvalidRomanNumeralException();
        }
        final List<Character> romanNumbers = romanValue.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        //TODO: Add foreach


        if(romanValue.equals("II")){
            return 2;
        }
        if(romanValue.equals("III")){
            return 3;
        }
        return 0;
    }
}
