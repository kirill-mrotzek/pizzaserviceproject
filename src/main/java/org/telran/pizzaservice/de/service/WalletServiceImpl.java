package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Wallet;
import org.telran.pizzaservice.de.exception.WalletNotFoundException;
import org.telran.pizzaservice.de.repository.WalletJpaRepository;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletJpaRepository walletJpaRepository;



    @Override
    public Optional<Wallet> getWalletByUserId(Long userId) {
        Optional<Wallet> wallet = walletJpaRepository.findByUserId(userId);

        if (wallet.isEmpty()) {
            throw new WalletNotFoundException("Wallet not found for user with ID: " + userId);
        }

        return wallet;
    }

    @Override
    public void loadMoney(Long userId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        Wallet wallet = walletJpaRepository.findByUserId(userId)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found for user with ID: " + userId));
        wallet.setBalance(wallet.getBalance() + amount);
        walletJpaRepository.save(wallet);
    }
}

