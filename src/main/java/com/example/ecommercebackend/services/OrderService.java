package com.example.ecommercebackend.services;

import com.example.ecommercebackend.entities.Order;
import com.example.ecommercebackend.entities.ShoppingCart;
import com.example.ecommercebackend.repositories.OrderRepository;
import com.example.ecommercebackend.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(Long cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found"));

        Order order = Order.builder()
                .items(cart.getCartItems())
                .totalPrice(cart.getTotalPrice())
                .orderDate(LocalDateTime.now())
                .status(Order.OrderStatus.PENDING)
                .build();

        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long orderId, Order.OrderStatus status) {
        return orderRepository.findById(orderId).map(order -> {
            order.setStatus(status);
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
