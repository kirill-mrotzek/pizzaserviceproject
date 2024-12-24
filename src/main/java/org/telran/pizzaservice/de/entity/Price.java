package org.telran.pizzaservice.de.entity;

public class Price {

    private String pizza;

    private double price;

    private double discount;

    public Price(String pizza, double price, double discount) {
        this.pizza = pizza;
        this.price = price;
        this.discount = discount;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
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
                "pizza='" + pizza + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
