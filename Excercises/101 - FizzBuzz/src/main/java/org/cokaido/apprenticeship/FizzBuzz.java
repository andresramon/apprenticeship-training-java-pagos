package org.cokaido.apprenticeship;

public class FizzBuzz {

    public String getFizzBuzz(int number)
    {
        if (number <= 0) {
            throw new RuntimeException();
        }
        return String.valueOf(number);
    }
}
