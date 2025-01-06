package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "price_list")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    private double price;

    private double discount;

    public Price(Long id, Pizza pizza, double price, double discount) {
        this.id = id;
        this.pizza = pizza;
        this.price = price;
        this.discount = discount;
    }

    public Price() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", pizza='" + pizza + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
