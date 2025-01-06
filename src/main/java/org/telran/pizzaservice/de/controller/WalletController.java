package org.telran.pizzaservice.de.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.dto.LoadMoneyRequest;
import org.telran.pizzaservice.de.entity.Wallet;
import org.telran.pizzaservice.de.exception.WalletNotFoundException;
import org.telran.pizzaservice.de.service.UserService;
import org.telran.pizzaservice.de.service.WalletService;

import java.util.Optional;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @GetMapping("/current")
    public ResponseEntity<Wallet> getByUserId() {
        Long currentUserId = userService.getCurrentUserId();

        Optional<Wallet> wallet = walletService.getWalletByUserId(currentUserId);
        return wallet.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }
    @PostMapping("/current/load_money")
    public ResponseEntity<String> loadMoneyToWallet(@Valid @RequestBody LoadMoneyRequest request)
            throws IllegalArgumentException, WalletNotFoundException {
        Long currentUserId = userService.getCurrentUserId();
        if (currentUserId == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        walletService.loadMoney(currentUserId, request.getAmount());
        return ResponseEntity.ok("Money successfully loaded to wallet.");
    }
}
