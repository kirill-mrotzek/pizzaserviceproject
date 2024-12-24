package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.Price;
import org.telran.pizzaservice.de.service.PriceService;

@RestController
@RequestMapping("/api/pricelists")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/{pizza}/set-price")
    public Price setPrice(@PathVariable(name = "pizza") String pizza, @RequestBody double price) {
        return priceService.setPrice(pizza, price);
    }

    @PutMapping("/{pizza}/change-discount")
    public Price changeDiscount(@PathVariable (name = "pizza") String pizza, @RequestBody double newDiscount) {
        return priceService.changeDiscount(pizza, newDiscount);
    }

    @DeleteMapping("/{pizza}")
    public void delete (@PathVariable(name = "pizza") String pizza) {
        priceService.delete(pizza);
    }
}
