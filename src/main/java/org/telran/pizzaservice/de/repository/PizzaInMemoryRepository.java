package org.telran.pizzaservice.de.repository;

import org.springframework.stereotype.Component;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.enums.Ingredients;

import java.util.HashMap;
import java.util.Map;

@Component
public class PizzaInMemoryRepository implements PizzaRepository {


    private Map<String, Pizza> storage = new HashMap<>();

    public PizzaInMemoryRepository() {
        init();
    }

    private void init() {
        Pizza pizza1 = new Pizza("Hawaii", 40, Ingredients.PINEAPPLE);
        Pizza pizza2 = new Pizza("Pepperoni", 40, Ingredients.PEPPERONI);
        Pizza pizza3 = new Pizza("Margherita", 40, Ingredients.CHEESE);
        storage.put(pizza1.getTitle(), pizza1);
        storage.put(pizza2.getTitle(), pizza2);
        storage.put(pizza3.getTitle(), pizza3);
    }

    @Override
    public Pizza getByTitle(String title) {
        return storage.get(title);
    }
}
