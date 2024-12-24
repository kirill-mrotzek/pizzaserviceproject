package org.telran.pizzaservice.de.repository;

import org.telran.pizzaservice.de.entity.Price;

public interface PriceRepository {

    Price save(double price);

    void delete(String pizza);

    Price put(double discount);
}
