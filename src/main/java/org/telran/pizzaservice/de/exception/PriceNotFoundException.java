package org.telran.pizzaservice.de.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}

