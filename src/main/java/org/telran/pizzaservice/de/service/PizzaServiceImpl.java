package org.telran.pizzaservice.de.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.entity.Price;
import org.telran.pizzaservice.de.exception.PizzaNotFoundException;
import org.telran.pizzaservice.de.repository.PizzaJpaRepository;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaJpaRepository pizzaJpaRepository;

    Logger log = LoggerFactory.getLogger(PizzaServiceImpl.class);

    @Override
    public Pizza getPizzaByTitle(String title) {
        List<Pizza> pizzas = pizzaJpaRepository.findByTitle(title);
        if (pizzas == null || pizzas.isEmpty()) {
            throw new PizzaNotFoundException("Pizza with title " + title + " not found");
        }
        return pizzas.get(0);
    }

    @Override
    public Pizza create(Pizza pizza) {
        log.info("Pizza created");
        return pizzaJpaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAll() {
        return pizzaJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pizzaJpaRepository.deleteById(id);
    }

    @Override
    public Pizza setPrice(Long id, double price) {
        Pizza entity = pizzaJpaRepository.findById(id)
                .orElseThrow(() -> new PizzaNotFoundException("Pizza with id " + id + " not found"));

        Price currentPrice = entity.getPrice();
        if (currentPrice == null) {
            currentPrice = new Price();
            entity.setPrice(currentPrice);
        }
        currentPrice.setPrice(price);
        pizzaJpaRepository.save(entity);

        return entity;
    }

    @Override
    public Pizza editPizza(Long id, Pizza updatedPizza) {
        Pizza existingPizza = pizzaJpaRepository.findById(id)
                .orElseThrow(() -> new PizzaNotFoundException("Pizza with id " + id + " not found"));

            existingPizza.setTitle(updatedPizza.getTitle());
            existingPizza.setSize(updatedPizza.getSize());
            existingPizza.setIngredients(updatedPizza.getIngredients());
            existingPizza.setPrice(updatedPizza.getPrice());
            existingPizza.setUser(updatedPizza.getUser());
            existingPizza.setPizzeria(updatedPizza.getPizzeria());

        return pizzaJpaRepository.save(existingPizza);
    }
}





