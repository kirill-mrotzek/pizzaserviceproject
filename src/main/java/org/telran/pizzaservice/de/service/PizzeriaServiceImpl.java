package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.repository.PizzaRepository;
import org.telran.pizzaservice.de.repository.PizzeriaRepository;

import java.util.List;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {

    @Autowired
    private PizzeriaRepository pizzeriaRepository;

    @Override
    public List<Pizzeria> getAll() {
        return pizzeriaRepository.getAll();
    }
}
