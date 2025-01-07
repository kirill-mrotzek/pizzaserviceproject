package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizzeria")
public class Pizzeria {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String city;

private String address;

private LocalTime openingTime;

private LocalTime closingTime;


    @OneToMany(mappedBy = "pizzeria", cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Pizzeria(Long id, String city, String address, LocalTime openingTime, LocalTime closingTime, List<Pizza> pizzas, User user) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.pizzas = pizzas;
        this.user = user;
    }

    // Конструктор по умолчанию
    public Pizzeria() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", pizzas=" + pizzas +
                ", user=" + user +
                '}';
    }
}