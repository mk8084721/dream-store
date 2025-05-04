package com.trachcode.dreamstore.service.cart;

import com.trachcode.dreamstore.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
}
