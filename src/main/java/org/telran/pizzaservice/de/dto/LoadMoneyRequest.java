package org.telran.pizzaservice.de.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LoadMoneyRequest {

    @NotNull
    @Positive
    private double amount;

    // Пустой конструктор для сериализации
    public LoadMoneyRequest() {
    }

    // Конструктор для удобства
    public LoadMoneyRequest(double amount) {
        this.amount = amount;
    }

    // Геттер и сеттер
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
