package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.service.PizzeriaService;

import java.util.List;

@RestController
@RequestMapping("/api/pizzerias")
public class PizzeriaController {

    @Autowired
    private PizzeriaService pizzeriaService;

    @GetMapping
    public List<Pizzeria> getAllPizzerias() {
        return pizzeriaService.getAllPizzerias();
    }

}
