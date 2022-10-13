package org.cokaido.apprenticeship;

public class FizzBuzz {

    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";

    public String getFizzBuzz(int number)
    {
        if (isNegativeOrZero(number)) {
            throw new RuntimeException();
        } 

        if (isDivisibleByThreeAndFive(number)) {
            return FIZZ_BUZZ;
        }

        if (isMultipleOfThree(number)) {
        	return FIZZ;
        }

        if (isMultipleOfFive(number)) {
        	return BUZZ;
        }
        
        return String.valueOf(number);
    }

    private boolean isDivisibleByThreeAndFive(int number) {
        return isMultipleOfThree(number) && isMultipleOfFive(number);
    }

    private boolean isNegativeOrZero(int number) {
		return number <= 0;
	}

	private boolean isMultipleOfThree(int number) {
		return number % 3 == 0;
	}

    private boolean isMultipleOfFive(int number) {
        return number % 5 == 0;
    }
    
}
