package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.DeliveryAddress;

import java.util.Optional;

public interface DeliveryAddressService {


    DeliveryAddress addAddressForCurrentUser(DeliveryAddress address);

    Optional<DeliveryAddress> getAddressByUserId(Long currentUserId);
}
