package com.example.ecommercebackend.controllers;

import com.example.ecommercebackend.entities.ShoppingCart;
import com.example.ecommercebackend.services.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-cart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(shoppingCartService.getShoppingCart(cartId));
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart() {
        return ResponseEntity.ok(shoppingCartService.createShoppingCart());
    }

    @PutMapping("/{cartId}/calculate")
    public ResponseEntity<Void> calculateTotalPrice(@PathVariable Long cartId) {
        shoppingCartService.calculateTotalPrice(cartId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long cartId) {
        shoppingCartService.deleteShoppingCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
