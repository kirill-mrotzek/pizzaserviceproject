package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.entity.Pizzeria;

import java.util.List;

public interface PizzeriaService {


    List<Pizzeria> getAll();

    void delete(Long id);

    Pizzeria create(Pizzeria pizzeria);

    Pizzeria editPizzeria(Long id, Pizzeria updatedPizzeria);

    Pizzeria addPizzaToPizzeria(Long pizzeriaId, Pizza pizza);
}
