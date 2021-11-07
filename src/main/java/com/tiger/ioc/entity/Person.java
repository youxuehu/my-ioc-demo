package com.tiger.ioc.entity;

import com.tiger.ioc.annotation.Autowired;
import com.tiger.ioc.annotation.Component;
import com.tiger.ioc.annotation.Qualifier;
import com.tiger.ioc.annotation.Value;

/**
 * @author youxuehu
 * @version v1.0
 * @className Person
 * @date 2021/11/7 7:20 下午
 * @desrription 这是类的描述信息
 */
@Component
public class Person {

    @Value("jack")
    private String name;

    @Value("20")
    private Integer age;

    @Autowired
    @Qualifier("order")
    private Order order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", order=" + order +
                '}';
    }
}
