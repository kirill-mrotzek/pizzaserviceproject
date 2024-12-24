package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Price;

public interface PriceService {

    void delete(String pizza);

    Price setPrice(String pizza, double price);

    Price changeDiscount(String pizza, double discount);
}
