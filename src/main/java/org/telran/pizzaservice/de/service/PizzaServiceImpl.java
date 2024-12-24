package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza getPizzaByTitle(String title) {
        return pizzaRepository.getByTitle(title);
    }
}
