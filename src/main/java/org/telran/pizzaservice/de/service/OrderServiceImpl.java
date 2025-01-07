package org.telran.pizzaservice.de.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Order;
import org.telran.pizzaservice.de.entity.Payment;
import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.enums.OrderStatus;
import org.telran.pizzaservice.de.exception.InvalidOrderStateException;
import org.telran.pizzaservice.de.exception.OrderNotFoundException;
import org.telran.pizzaservice.de.repository.OrderJpaRepository;
import org.telran.pizzaservice.de.repository.PaymentJpaRepository;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    private PaymentJpaRepository paymentJpaRepository;

    @Autowired
    private PizzeriaService pizzeriaService;

    Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    @Scheduled(cron="0 0 9-18 * * MON-FRI")
    public Order createOrder(Order order) {
        Pizzeria pizzeria = order.getPizzeria();
        LocalTime time = LocalTime.now();
        if (!pizzeriaService.canAcceptOrder(pizzeria, time)) {
            throw new IllegalArgumentException("Pizzeria is closed at this time");
        }
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);
        log.info("Order created");
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
            throw new InvalidOrderStateException("Order is not in CREATED state and cannot be paid");
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

    @Scheduled(fixedRate = 30, timeUnit = TimeUnit.SECONDS)
    public void processPaidOrders() {
        List<Order> paidOrders = orderJpaRepository.findByStatus(OrderStatus.PAID);
        for (Order order : paidOrders) {
            if (order.getUpdatedAt().isBefore(LocalDateTime.now().minusMinutes(5))) {
                order.setStatus(OrderStatus.READY);
                orderJpaRepository.save(order);
                log.info("Order ID " + order.getId() + " has been updated to READY");
            }
        }
    }

    @Scheduled(fixedRate = 30, timeUnit = TimeUnit.SECONDS)
    public void processReadyOrders() {
        List<Order> readyOrders = orderJpaRepository.findByStatus(OrderStatus.READY);
        for (Order order : readyOrders) {
            if (order.getUpdatedAt().isBefore(LocalDateTime.now().minusMinutes(5))) {
                order.setStatus(OrderStatus.DELIVERED);
                orderJpaRepository.save(order);
                log.info("Order ID " + order.getId() + " has been updated to DELIVERED");
            }
        }
    }

    @Scheduled(fixedRate = 30, timeUnit = TimeUnit.SECONDS)
    public void processCreatedOrders() {
        List<Order> createdOrders = orderJpaRepository.findByStatus(OrderStatus.CREATED);

        for (Order order : createdOrders) {
            if (order.getUpdatedAt().isBefore(LocalDateTime.now().minusMinutes(10))) {
                order.setStatus(OrderStatus.CANCELLED);
                orderJpaRepository.save(order);
                log.info("Order ID " + order.getId() + " has been updated to CANCELLED");
            }
        }
    }
}

