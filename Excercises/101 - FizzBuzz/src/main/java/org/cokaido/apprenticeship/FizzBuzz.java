package org.cokaido.apprenticeship;

public class FizzBuzz {

    public static final String BUZZ = "Buzz";
    final String FIZZ = "Fizz";
	
    public String getFizzBuzz(int number)
    {
        if (isNegativeOrZero(number)) {
            throw new RuntimeException();
        } 
        
        if (isMultipleOfThree(number)) {
        	return FIZZ;
        }

        if (isMultipleOfFive(number)) {
        	return BUZZ;
        }
        
        return String.valueOf(number);
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
