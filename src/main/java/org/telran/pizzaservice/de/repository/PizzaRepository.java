package org.telran.pizzaservice.de.repository;

import org.telran.pizzaservice.de.entity.Pizza;

import java.util.List;

public interface PizzaRepository {

    Pizza getByTitle(String title);

    List<Pizza> getAllPizzas();
}
