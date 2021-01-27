package com.suze.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-15 11:28 PM
 */
public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalPrice;

    /**
     * key是商品编号
     * value是商品信息
     */

    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());

        if(item == null){
            items.put(cartItem.getId(), cartItem);
        }else{
            item.setCount (item.getCount()+1); //数目累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }
    }

    /**
     * 删除商品
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车，不需要参数
     */
    public void clear(){
        items.clear();
    }

    /**
     * 添加商品项
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Cart() {
    }



    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer, CartItem>entry: items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }

    public BigDecimal getTotalPrice() {

        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer, CartItem>entry: items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

}
