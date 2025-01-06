package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Order;
import org.telran.pizzaservice.de.enums.OrderStatus;

import java.util.List;

public interface OrderService {


    Order createOrder(Order order);

    List<Order> listOrdersForCurrentUser(Long currentUserId);

    Order payOrder(Long id, double totalSum);

    Order cancelOrder(Long id);

}
