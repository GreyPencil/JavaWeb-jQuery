package com.suze.dao.impl;

import com.suze.dao.OrderItemDao;
import com.suze.pojo.OrderItem;;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 7:01 PM
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
