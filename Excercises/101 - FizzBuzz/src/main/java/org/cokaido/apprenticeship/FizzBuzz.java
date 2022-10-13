package org.cokaido.apprenticeship;

public class FizzBuzz {

	final String FIZZ = "Fizz";
	
    public String getFizzBuzz(int number)
    {
        if (isNegativeOrZero(number)) {
            throw new RuntimeException();
        } 
        
        if (isMultipleOfThree(number)) {
        	return FIZZ;
        }
        
        return String.valueOf(number);
    }

	private boolean isNegativeOrZero(int number) {
		return number <= 0;
	}

	private boolean isMultipleOfThree(int number) {
		return number % 3 == 0;
	}
    
}
