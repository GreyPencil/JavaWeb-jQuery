package com.suze.test;

import com.suze.pojo.Cart;
import com.suze.pojo.CartItem;
import com.suze.service.OrderService;
import com.suze.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 10:23 PM
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "计算机网路",1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(3, "计算机网路2",2, new BigDecimal(30), new BigDecimal(60)));

        OrderService orderService = new OrderServiceImpl();


        System.out.println("Order number is: "+ orderService.createOrder(cart,1));

    }
}