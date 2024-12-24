package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.enums.Ingredients;

import java.util.List;

public interface PizzaService {

    Pizza getPizzaByTitle(String title);
}
