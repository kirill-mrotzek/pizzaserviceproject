package org.telran.pizzaservice.de.converter;

import org.springframework.stereotype.Component;
import org.telran.pizzaservice.de.dto.WalletCreateDto;
import org.telran.pizzaservice.de.dto.WalletResponseDto;
import org.telran.pizzaservice.de.entity.Wallet;

@Component
public class WalletCreateConverter implements Converter<Wallet, WalletCreateDto, WalletResponseDto> {

    @Override
    public WalletResponseDto toDto(Wallet wallet) {
        return new WalletResponseDto(wallet.getId(), wallet.getBalance(), wallet.getCurrency());
    }

    @Override
    public Wallet toEntity(WalletCreateDto walletCreateDto) {
        return new Wallet(walletCreateDto.getInitialBalance(), walletCreateDto.getCurrency());

    }
}
