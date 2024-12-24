package org.telran.pizzaservice.de.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telran.pizzaservice.de.service.PriceService;

@RestController
@RequestMapping("/api/pricelists")
public class PriceController {

    @Autowired
    private PriceService priceService;
}
