package com.tiger.ioc.entity;

import com.tiger.ioc.annotation.Component;
import com.tiger.ioc.annotation.Value;

/**
 * @author youxuehu
 * @version v1.0
 * @className Order
 * @date 2021/11/7 7:30 下午
 * @desrription 这是类的描述信息
 */
@Component
public class Order {
    @Value("123")
    private Integer orderId;
    @Value("10000.0")
    private Float price;
    @Value("测试订单")
    private String orderName;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
