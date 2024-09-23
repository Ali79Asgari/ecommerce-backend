package com.example.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @Column(nullable = false)
    private Double totalPrice;

    public void calculateTotalPrice() {
        this.totalPrice = cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}
