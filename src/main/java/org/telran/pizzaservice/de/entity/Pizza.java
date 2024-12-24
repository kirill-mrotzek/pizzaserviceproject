package org.telran.pizzaservice.de.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.telran.pizzaservice.de.enums.Ingredients;

public class Pizza {

    private  String title;

    private int size;

    @Enumerated(EnumType.STRING)
    private Ingredients ingredients;

    public Pizza(String title, int size, Ingredients ingredients) {
        this.title = title;
        this.size = size;
        this.ingredients = ingredients;
    }

    public Pizza() {
        //
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "title='" + title + '\'' +
                ", size=" + size +
                ", ingredients=" + ingredients +
                '}';
    }
}
