package org.telran.pizzaservice.de.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telran.pizzaservice.de.entity.Price;
import org.telran.pizzaservice.de.exception.PriceNotFoundException;
import org.telran.pizzaservice.de.repository.PriceJpaRepository;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceJpaRepository priceJpaRepository;

    Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);

       @Override
    public void delete(Long id) {
        priceJpaRepository.deleteById(id);
    }

    @Override
    public Price create(Price price) {
           Price newPrice = priceJpaRepository.save(price);
        log.info("Successfully created price: " + newPrice);
        return newPrice;
    }

    @Transactional
    public Price editDiscount(Long id, double discount) {
        Price price = priceJpaRepository.findById(id)
                .orElseThrow(() -> new PriceNotFoundException("Price with id " + id + " not found"));
        price.setDiscount(discount);
        return priceJpaRepository.save(price);
    }

}
