package com.tiger.ioc.ioc;

import com.alibaba.fastjson.JSON;

/**
 * @author youxuehu
 * @version v1.0
 * @className BeanDefination
 * @date 2021/11/7 7:42 下午
 * @desrription 这是类的描述信息
 */
public class BeanDefinition {

    private String beanName;

    private Class<?> clazz;

    public BeanDefinition(String beanName, Class<?> clazz) {
        this.beanName = beanName;
        this.clazz = clazz;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }
}
