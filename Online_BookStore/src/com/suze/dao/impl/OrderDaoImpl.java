package com.suze.dao.impl;

import com.suze.dao.OrderDao;
import com.suze.pojo.Order;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 7:00 PM
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
