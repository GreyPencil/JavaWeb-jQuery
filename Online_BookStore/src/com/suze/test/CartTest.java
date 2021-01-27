package com.suze.test;

import com.suze.pojo.Cart;
import com.suze.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-15 11:57 PM
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "计算机网路",1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(3, "计算机网路2",2, new BigDecimal(30), new BigDecimal(60)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "计算机网路",1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(3, "计算机网路2",2, new BigDecimal(30), new BigDecimal(60)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "计算机网路",1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(3, "计算机网路2",2, new BigDecimal(30), new BigDecimal(60)));

        cart.deleteItem(1);
        cart.clear();;

        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "计算机网路",1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(3, "计算机网路2",2, new BigDecimal(30), new BigDecimal(60)));

        cart.deleteItem(1);
        cart.clear();;
        cart.addItem(new CartItem(1, "java从入门到精通",1, new BigDecimal(100), new BigDecimal(100)));

        cart.updateCount(1,5);

        System.out.println(cart);

    }
}