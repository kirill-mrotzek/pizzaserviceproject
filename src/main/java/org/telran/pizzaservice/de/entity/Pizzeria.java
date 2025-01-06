package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;
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

private String workingHours;


    @OneToMany(mappedBy = "pizzeria", cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Pizzeria(Long id, String city, String address, String workingHours, List<Pizza> pizzas, User user) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.workingHours = workingHours;
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

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
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
                ", workingHours='" + workingHours + '\'' +
                ", pizzas=" + pizzas +
                ", user=" + user +
                '}';
    }
}