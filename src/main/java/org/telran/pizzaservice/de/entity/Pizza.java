package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private  String title;

    private int size;

    private String ingredients;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "price_id", referencedColumnName = "id")//это колонка в таблице пицц
    private Price price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "pizzeria_id")
    private Pizzeria pizzeria;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cart_item_id")
    private CartItem cartItem;

    public Pizza(Long id, String title, int size, String ingredients, Price price, User user, Pizzeria pizzeria, CartItem cartItem) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.ingredients = ingredients;
        this.price = price;
        this.user = user;
        this.pizzeria = pizzeria;
        this.cartItem = cartItem;
    }

    public Pizza() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                ", user=" + user +
                ", pizzeria=" + pizzeria +
                '}';
    }
}
