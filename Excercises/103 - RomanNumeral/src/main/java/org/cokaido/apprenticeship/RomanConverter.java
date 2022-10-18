package org.cokaido.apprenticeship;

public class RomanConverter {
    public int convert(RomanNumeral romanValue) throws InvalidRomanNumeralException{
        if(romanValue == null){
            throw new InvalidRomanNumeralException();
        }
        switch (romanValue) {
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

    public int convert(String romanValue) throws InvalidRomanNumeralException{
        if(romanValue == null){
            throw new InvalidRomanNumeralException();
        }
        if(romanValue.equals("II")){
            return 2;
        }
        return 0;
    }
}
