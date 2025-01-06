package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza getPizzaByTitle(String title);

    Pizza create(Pizza pizza);

    List<Pizza> getAll();

    void delete(Long id);

    Pizza setPrice(Long id, double price);

    Pizza editPizza(Long id, Pizza updatedPizza);
}
