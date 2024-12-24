package org.telran.pizzaservice.de.entity;

public class Pizzeria {

private String city;

private String address;

private double workingHours;

    public Pizzeria(String city, String address, double workingHours) {
        this.city = city;
        this.address = address;
        this.workingHours = workingHours;
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

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", workingHours=" + workingHours +
                '}';
    }
}
