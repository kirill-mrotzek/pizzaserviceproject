package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.Order;
import org.telran.pizzaservice.de.enums.OrderStatus;
import org.telran.pizzaservice.de.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<Order> payOrder(@PathVariable Long id, @RequestParam double totalSum) {
        Order paidOrder = orderService.payOrder(id, totalSum);
        return ResponseEntity.ok(paidOrder);
    }

    @GetMapping("/current_user")
    public ResponseEntity<List<Order>> getCurrentUserOrders() {
        Long currentUserId = getCurrentUserId();
        List<Order>orders = orderService.listOrdersForCurrentUser(currentUserId);
        return ResponseEntity.ok(orders);
    }

    private Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            return Long.valueOf(userDetails.getUsername());
        }
        throw new IllegalStateException("User not authenticated");
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {
        Order cancelledOrder = orderService.cancelOrder(id);
        return ResponseEntity.ok(cancelledOrder);
    }
}
