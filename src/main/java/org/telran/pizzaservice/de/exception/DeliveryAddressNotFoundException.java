package org.telran.pizzaservice.de.exception;

public class DeliveryAddressNotFoundException extends RuntimeException {

    public DeliveryAddressNotFoundException(String message) {
        super(message);
    }
}
