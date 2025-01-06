package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

    private String currency;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Wallet(Long id, double balance, String currency, User user) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public Wallet() {
        //
    }

    public Wallet(double balance, String currency) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
