package org.telran.pizzaservice.de.exception;

public class PizzaNotFoundException extends RuntimeException {

    public PizzaNotFoundException(String message) {
        super(message);
    }
}
