package org.cokaido.apprenticeship;

public class FizzBuzz {

	final String FIZZ = "Fizz";
	
    public String getFizzBuzz(int number)
    {
        if (number <= 0) {
            throw new RuntimeException();
        } else if (number % 3 == 0) {
        	return FIZZ;
        }
        
        return String.valueOf(number);
    }
}
