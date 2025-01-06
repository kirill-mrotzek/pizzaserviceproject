package org.telran.pizzaservice.de.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double totalSum;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private LocalDateTime paymentDate;

    public Payment(Long id, double totalSum, Order order, LocalDateTime paymentDate) {
        this.id = id;
        this.totalSum = totalSum;
        this.order = order;
        this.paymentDate = paymentDate;
    }

    public Payment() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
