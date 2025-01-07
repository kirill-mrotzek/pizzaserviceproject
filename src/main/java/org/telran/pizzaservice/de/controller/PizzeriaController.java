package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.Pizza;
import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.service.PizzeriaService;

import java.util.List;

@RestController
@RequestMapping("/api/pizzerias")
public class PizzeriaController {

    @Autowired
    private PizzeriaService pizzeriaService;

    @PostMapping("/{id}")
    public Pizzeria create (@RequestBody Pizzeria pizzeria) {
        return pizzeriaService.create(pizzeria);
    }

    @PostMapping("/{pizzeriaId}/addPizza")
    public Pizzeria addPizzaToPizzeria(
            @PathVariable Long pizzeriaId,
            @RequestBody Pizza pizza) {
        return pizzeriaService.addPizzaToPizzeria(pizzeriaId, pizza);
    }

    @PutMapping("/{id}")
    public Pizzeria editPizzeria(
            @PathVariable Long id,
            @RequestBody Pizzeria updatedPizzeria) {
        return pizzeriaService.editPizzeria(id, updatedPizzeria);
    }

    @GetMapping
    public List<Pizzeria> getAll() {
        return pizzeriaService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable(name = "id") Long id) {
        pizzeriaService.delete(id);
    }
}
