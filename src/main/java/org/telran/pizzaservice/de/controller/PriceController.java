package org.telran.pizzaservice.de.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.Price;
import org.telran.pizzaservice.de.service.PriceService;

@RestController
@RequestMapping("/api/pricelists")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        priceService.delete(id);
    }

    @PostMapping
    public Price create(@RequestBody @Valid Price price) {
        return priceService.create(price);
    }

    @PutMapping("/{id}/discount")
    public Price editDiscount(@PathVariable Long id, @RequestParam double discount) {
        return priceService.editDiscount(id, discount);
    }


}
