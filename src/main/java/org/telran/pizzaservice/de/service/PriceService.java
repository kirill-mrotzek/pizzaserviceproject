package org.telran.pizzaservice.de.service;

import jakarta.validation.Valid;
import org.telran.pizzaservice.de.entity.Price;

public interface PriceService {

    void delete(Long id);

    Price create(@Valid Price price);

    Price editDiscount(Long id, double discount);
}
