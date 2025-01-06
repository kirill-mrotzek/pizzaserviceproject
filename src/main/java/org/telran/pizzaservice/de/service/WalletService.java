package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Wallet;

import java.util.Optional;

public interface WalletService {

    Optional<Wallet> getWalletByUserId(Long userId);

    void loadMoney(Long userId, double amount);
}
