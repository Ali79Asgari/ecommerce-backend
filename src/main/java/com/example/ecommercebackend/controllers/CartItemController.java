package com.example.ecommercebackend.controllers;

import com.example.ecommercebackend.entities.CartItem;
import com.example.ecommercebackend.services.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/{cartId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartItemService.getCartItems(cartId));
    }

    @PostMapping("/{cartId}/add/{productId}")
    public ResponseEntity<CartItem> addCartItem(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam int quantity) {
        return ResponseEntity.ok(cartItemService.addCartItem(cartId, productId, quantity));
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long cartItemId, @RequestParam int quantity) {
        return ResponseEntity.ok(cartItemService.updateCartItem(cartItemId, quantity));
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long cartItemId) {
        cartItemService.removeCartItem(cartItemId);
        return ResponseEntity.noContent().build();
    }
}
