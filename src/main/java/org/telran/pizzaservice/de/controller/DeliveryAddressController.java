package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.DeliveryAddress;
import org.telran.pizzaservice.de.service.DeliveryAddressService;
import org.telran.pizzaservice.de.service.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/api/addresses")
public class DeliveryAddressController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/current")
    public ResponseEntity<DeliveryAddress> getByUserId() {
        Long currentUserId = userService.getCurrentUserId();
        if (currentUserId == null) {
            return ResponseEntity.status(401).build();
        }
        Optional<DeliveryAddress> address = deliveryAddressService.getAddressByUserId(currentUserId);
        return address.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @PostMapping
    public ResponseEntity<DeliveryAddress> addAddressForCurrentUser(@RequestBody DeliveryAddress address) {
        DeliveryAddress savedAddress = deliveryAddressService.addAddressForCurrentUser(address);

        return ResponseEntity.status(201).body(savedAddress);
    }

}
