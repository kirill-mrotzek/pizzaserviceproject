package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;
import org.telran.pizzaservice.de.enums.OrderStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "delivery_address_id")
    private DeliveryAddress deliveryAddress;

    @Column
    private double totalSum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.CREATED;


    @Column
    private LocalDateTime createdAt;

    public Order(Long id, List<CartItem> cartItems, User user, DeliveryAddress deliveryAddress,
                 double totalSum, Payment payment, OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.cartItems = cartItems;
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.totalSum = totalSum;
        this.payment = payment;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Order() {
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
