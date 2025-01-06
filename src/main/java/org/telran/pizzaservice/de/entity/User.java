package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.antlr.v4.runtime.misc.NotNull;
import org.telran.pizzaservice.de.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizzeria_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private  String login;

    @Pattern(regexp = "(?=.*\\\\d).{3,}$")
    private String password;

    private String name;

    private String surname;

    @Email
    private String email;

    //@NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") //это колонка в таблице адресов с id пользователя - внешний ключ
    private List<DeliveryAddress>deliveryAddresses = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")//это колонка в таблице пользователей
    private Wallet wallet;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Pizza>pizzas = new ArrayList<>();

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizzeria_id")
    private List<Pizzeria>pizzerias = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")//это колонка в таблице пользователей
    private Order order;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    public User(Long id, String login, String password, String name, String surname, String email, List<DeliveryAddress> deliveryAddresses, Wallet wallet, List<Pizza> pizzas, List<Pizzeria> pizzerias, Order order) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.deliveryAddresses = deliveryAddresses;
        this.wallet = wallet;
        this.pizzas = pizzas;
        this.pizzerias = pizzerias;
        this.order = order;
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank String login) {
        this.login = login;
    }

    public @Pattern(regexp = "(?=.*\\\\d).{3,}$") String getPassword() {
        return password;
    }

    public void setPassword(@Pattern(regexp = "(?=.*\\\\d).{3,}$") String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotEmpty List<DeliveryAddress> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public void setDeliveryAddresses(@NotEmpty List<DeliveryAddress> deliveryAddresses) {
        this.deliveryAddresses = deliveryAddresses;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public @NotEmpty List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(@NotEmpty List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public @NotEmpty List<Pizzeria> getPizzerias() {
        return pizzerias;
    }

    public void setPizzerias(@NotEmpty List<Pizzeria> pizzerias) {
        this.pizzerias = pizzerias;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", deliveryAddresses=" + deliveryAddresses +
                ", wallet=" + wallet +
                ", pizzas=" + pizzas +
                ", pizzerias=" + pizzerias +
                '}';
    }
}
