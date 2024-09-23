package com.example.ecommercebackend.services;

import com.example.ecommercebackend.entities.ShoppingCart;
import com.example.ecommercebackend.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart getShoppingCart(Long cartId) {
        return shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found"));
    }

    public ShoppingCart createShoppingCart() {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .totalPrice(0.0)
                .build();
        return shoppingCartRepository.save(shoppingCart);
    }

    public void calculateTotalPrice(Long cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found"));
        cart.calculateTotalPrice();
        shoppingCartRepository.save(cart);
    }

    public void deleteShoppingCart(Long cartId) {
        shoppingCartRepository.deleteById(cartId);
    }
}
