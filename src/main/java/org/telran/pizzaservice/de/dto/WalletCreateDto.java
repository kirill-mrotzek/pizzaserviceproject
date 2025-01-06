package org.telran.pizzaservice.de.dto;

public class WalletCreateDto {
    private double initialBalance;
    private String currency;

    public WalletCreateDto() {
        //
    }

    public WalletCreateDto(double initialBalance, String currency) {
        this.initialBalance = initialBalance;
        this.currency = currency;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}