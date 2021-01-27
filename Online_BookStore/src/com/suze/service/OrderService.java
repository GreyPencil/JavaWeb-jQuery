package com.suze.service;

import com.suze.pojo.Cart;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 7:15 PM
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
