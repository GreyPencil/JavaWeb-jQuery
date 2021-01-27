package com.suze.service.impl;

import com.suze.dao.BookDao;
import com.suze.dao.OrderDao;
import com.suze.dao.OrderItemDao;
import com.suze.dao.impl.BookDaoImpl;
import com.suze.dao.impl.OrderDaoImpl;
import com.suze.dao.impl.OrderItemDaoImpl;
import com.suze.pojo.*;
import com.suze.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 7:16 PM
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis() + "" + userId; //改成String加双引号
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);

//        int i = 12/0;

        //将cartitem转成 orderitem
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {

            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);

            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);

        }
        cart.clear();

        return orderId;
    }
}
