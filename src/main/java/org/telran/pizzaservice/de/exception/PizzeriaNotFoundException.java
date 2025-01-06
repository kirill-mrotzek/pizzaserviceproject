package org.telran.pizzaservice.de.exception;

public class PizzeriaNotFoundException extends RuntimeException{
    public PizzeriaNotFoundException(String message) {
        super(message);
    }
}
