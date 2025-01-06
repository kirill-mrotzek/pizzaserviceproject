package org.telran.pizzaservice.de.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.exception.PizzeriaNotFoundException;
import org.telran.pizzaservice.de.repository.PizzaJpaRepository;
import org.telran.pizzaservice.de.repository.PizzeriaJpaRepository;

import java.util.List;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {

    @Autowired
    private PizzeriaJpaRepository pizzeriaJpaRepository;

    @Autowired
    private PizzaJpaRepository pizzaJpaRepository;

    Logger log = LoggerFactory.getLogger(PizzeriaServiceImpl.class);


    @Override
    public List<Pizzeria> getAll() {
        return pizzeriaJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pizzeriaJpaRepository.deleteById(id);
    }

    @Override
    public Pizzeria create(Pizzeria pizzeria) {
        log.info("Pizzeria successfully created");
        return pizzeriaJpaRepository.save(pizzeria);
    }


    @Override
    public Pizzeria editPizzeria(Long id, Pizzeria updatedPizzeria) {
        Pizzeria existingPizzeria = pizzeriaJpaRepository.findById(id)
                .orElseThrow(() -> new PizzeriaNotFoundException("Pizzeria with id " + id + " not found"));

        existingPizzeria.setCity(updatedPizzeria.getCity());
        existingPizzeria.setAddress(updatedPizzeria.getAddress());
        existingPizzeria.setWorkingHours(updatedPizzeria.getWorkingHours());
        existingPizzeria.setUser(updatedPizzeria.getUser());

        return pizzeriaJpaRepository.save(existingPizzeria);
    }

    @Override
    public Pizzeria addPizzaToPizzeria(Long pizzeriaId, Pizza pizza) {
        Pizzeria pizzeria = pizzeriaJpaRepository.findById(pizzeriaId)
                .orElseThrow(() -> new RuntimeException("Pizzeria with id " + pizzeriaId + " not found"));

        pizza.setPizzeria(pizzeria);
        pizzaJpaRepository.save(pizza);
        pizzeria.getPizzas().add(pizza);

        return pizzeriaJpaRepository.save(pizzeria);
    }
}
