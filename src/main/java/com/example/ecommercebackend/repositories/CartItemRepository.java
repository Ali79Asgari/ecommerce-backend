package com.example.ecommercebackend.repositories;

import com.example.ecommercebackend.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByShoppingCartId(Long cartId);
}
