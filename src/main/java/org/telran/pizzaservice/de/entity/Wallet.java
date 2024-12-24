package org.telran.pizzaservice.de.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.telran.pizzaservice.de.enums.Currency;
import org.telran.pizzaservice.de.enums.Ingredients;

public class Wallet {

    private double balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}
