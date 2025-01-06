package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cartItem", cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_id")
    private Order order;

    private int amount;

    private double pricePerOne;

    private double totalPrice;

    public CartItem(Long id, List<Pizza> pizzas, Cart cart, Order order, int amount, double pricePerOne, double totalPrice) {
        this.id = id;
        this.pizzas = pizzas;
        this.cart = cart;
        this.order = order;
        this.amount = amount;
        this.pricePerOne = pricePerOne;
        this.totalPrice = totalPrice;
    }

    public CartItem() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPricePerOne() {
        return pricePerOne;
    }

    public void setPricePerOne(double pricePerOne) {
        this.pricePerOne = pricePerOne;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
