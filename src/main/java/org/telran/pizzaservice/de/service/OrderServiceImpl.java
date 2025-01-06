package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Order;
import org.telran.pizzaservice.de.entity.Payment;
import org.telran.pizzaservice.de.enums.OrderStatus;
import org.telran.pizzaservice.de.exception.OrderNotFoundException;
import org.telran.pizzaservice.de.repository.OrderJpaRepository;
import org.telran.pizzaservice.de.repository.PaymentJpaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    private PaymentJpaRepository paymentJpaRepository;

    @Override
    public Order createOrder(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);
        return orderJpaRepository.save(order);
    }

    @Override
    public List<Order> listOrdersForCurrentUser(Long currentUserId) {
        return orderJpaRepository.findByUserId(currentUserId);
    }

    @Override
    public Order payOrder(Long id, double totalSum) {
        Order orderToPay = orderJpaRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found"));

        if (orderToPay.getStatus() != OrderStatus.CREATED) {
            throw new IllegalStateException("Order is not in CREATED state and cannot be paid");
        }

        Payment payment = new Payment(null, totalSum, orderToPay, LocalDateTime.now());
        paymentJpaRepository.save(payment);
        orderToPay.setStatus(OrderStatus.PAID);
        orderToPay.setPayment(payment);
        return orderJpaRepository.save(orderToPay);
    }


    @Override
    public Order cancelOrder(Long id) {
        Order orderToCancel = orderJpaRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found"));

        if (orderToCancel.getStatus() == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Order status is CANCELLED");
        }

        orderToCancel.setStatus(OrderStatus.CANCELLED);
        return orderJpaRepository.save(orderToCancel);
    }

}
