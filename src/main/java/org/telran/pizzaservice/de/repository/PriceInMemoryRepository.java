package org.telran.pizzaservice.de.repository;

import org.springframework.stereotype.Component;
import org.telran.pizzaservice.de.entity.Price;

@Component
public class PriceInMemoryRepository implements PriceRepository {

    @Override
    public Price save(double price) {
        return null;
    }

    @Override
    public void delete(String pizza) {

    }

    @Override
    public Price put(double discount) {
        return null;
    }
}
