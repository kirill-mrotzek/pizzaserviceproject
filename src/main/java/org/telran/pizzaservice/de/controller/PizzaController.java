package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.entity.User;
import org.telran.pizzaservice.de.service.PizzaService;

import java.util.List;

//http://localhost:8080

@RestController
@RequestMapping("/api/pizzas") // http://localhost:8080/api/pizzas
                                  // server path + port + controller path
public class PizzaController {

    @Autowired // Field injection
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAll() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{title}")
    public Pizza getPizzaInfo(@PathVariable(name = "title") String title) {
        return pizzaService.getPizzaByTitle(title);
    }

}
