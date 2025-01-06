package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telran.pizzaservice.de.entity.DeliveryAddress;
import org.telran.pizzaservice.de.entity.User;
import org.telran.pizzaservice.de.exception.DeliveryAddressNotFoundException;
import org.telran.pizzaservice.de.repository.DeliveryAddressJpaRepository;

import java.util.Optional;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    private DeliveryAddressJpaRepository deliveryAddressJpaRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public DeliveryAddress addAddressForCurrentUser(DeliveryAddress address) {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }
        address.setUser(currentUser);
        return deliveryAddressJpaRepository.save(address);
    }

    @Override
    public Optional<DeliveryAddress> getAddressByUserId(Long userId) {
        Optional<DeliveryAddress> address = deliveryAddressJpaRepository.findById(userId);
        if (address.isEmpty()) {
            throw new DeliveryAddressNotFoundException("Address not found for user with id " + userId);
        }
        return address;
    }
}
