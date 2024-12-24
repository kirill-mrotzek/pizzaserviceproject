package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Price;
import org.telran.pizzaservice.de.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price changeDiscount(String pizza, double discount) {
        return priceRepository.put(discount);
    }

    @Override
    public void delete(String pizza) {
        priceRepository.delete(pizza);
    }

    @Override
    public Price setPrice(String pizza, double price) {
        return priceRepository.save(price);
    }
}
