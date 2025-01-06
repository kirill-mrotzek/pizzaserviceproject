package org.telran.pizzaservice.de.dto;

public class WalletResponseDto {
    private Long id;
    private double balance;
    private String currency;

    public WalletResponseDto() {
        //
    }

    public WalletResponseDto(Long id, double balance, String currency) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
