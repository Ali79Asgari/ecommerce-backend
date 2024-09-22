package com.example.ecommercebackend.services;

import com.example.ecommercebackend.entities.CartItem;
import com.example.ecommercebackend.entities.Product;
import com.example.ecommercebackend.entities.ShoppingCart;
import com.example.ecommercebackend.repositories.CartItemRepository;
import com.example.ecommercebackend.repositories.ProductRepository;
import com.example.ecommercebackend.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public List<CartItem> getCartItems(Long cartId) {
        return cartItemRepository.findByShoppingCartId(cartId);
    }

    public CartItem addCartItem(Long cartId, Long productId, int quantity) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Product is out of stock");
        }

        CartItem cartItem = CartItem.builder()
                .product(product)
                .quantity(quantity)
                .shoppingCart(cart)
                .build();

        return cartItemRepository.save(cartItem);
    }

    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public CartItem updateCartItem(Long cartItemId, int quantity) {
        return cartItemRepository.findById(cartItemId).map(cartItem -> {
            cartItem.setQuantity(quantity);
            return cartItemRepository.save(cartItem);
        }).orElseThrow(() -> new RuntimeException("Cart item not found"));
    }
}
