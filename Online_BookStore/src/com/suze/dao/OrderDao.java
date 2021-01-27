package com.suze.dao;

import com.suze.pojo.Order;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 6:59 PM
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
