package com.suze.test;

import com.suze.dao.OrderDao;
import com.suze.dao.impl.OrderDaoImpl;
import com.suze.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 7:07 PM
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567892",new Date(),new BigDecimal(100),0, 1));


    }
}