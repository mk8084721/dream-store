package com.trachcode.dreamstore.repository;

import com.trachcode.dreamstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Cart, Long> {
    void deleteAllByCartId(Long id);
}