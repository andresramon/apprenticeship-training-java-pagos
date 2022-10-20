package org.cokaido.apprenticeship;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanConverter {

    public int convert(String romanValue) throws InvalidRomanNumeralException{
        checkValidRomanValue(romanValue);

        IntStream numbersStream = romanValue.chars().
                mapToObj(c -> (char) c).mapToInt(character -> RomanNumeral.getValue(RomanNumeral.valueOf(character.toString())));

        List<Integer> numbersList = numbersStream.boxed().collect(Collectors.toList());

        int total = 0;

        for (int index = numbersList.size() - 1; index>=0; index--) {
            if (index == numbersList.size() - 1) {
                total += numbersList.get(index);
            } else {
                if (numbersList.get(index) < numbersList.get(index + 1)) {
                    total -= numbersList.get(index);
                } else {
                    total += numbersList.get(index);
                }
            }
        }

        return total;
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
