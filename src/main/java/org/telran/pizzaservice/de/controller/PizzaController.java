package org.telran.pizzaservice.de.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.service.PizzaService;

import java.util.List;

//http://localhost:8080

@RestController
@RequestMapping("/api/pizzas") // http://localhost:8080/api/pizzas
                                  // server path + port + controller path
public class PizzaController {

    @Autowired // Field injection
    private PizzaService pizzaService;

    @PostMapping("/{id}")
    public Pizza create (@RequestBody @Valid Pizza pizza) {
        return pizzaService.create(pizza);
    }

    @GetMapping
    public List<Pizza> getAll() {
        return pizzaService.getAll();
    }

    @GetMapping("/{title}")
    public Pizza getByTitle(@PathVariable(name = "title") String title) {
        return pizzaService.getPizzaByTitle(title);
    }

    @PutMapping("/setprice/{id}")
    public Pizza setPrice(@PathVariable Long id, @RequestParam double price) {
        return pizzaService.setPrice(id, price);
    }

    @PutMapping("/{id}")
    public Pizza editPizza(@PathVariable Long id, @RequestBody Pizza updatedPizza) {
        return pizzaService.editPizza(id, updatedPizza);

    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        pizzaService.delete(id);
    }
}
