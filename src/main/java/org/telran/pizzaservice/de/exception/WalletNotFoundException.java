package org.telran.pizzaservice.de.exception;

public class WalletNotFoundException extends RuntimeException{

    public WalletNotFoundException(String message) {
        super(message);
    }
}
