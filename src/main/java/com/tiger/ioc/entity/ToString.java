package com.tiger.ioc.entity;

import com.alibaba.fastjson.JSON;

/**
 * @author youxuehu
 * @version v1.0
 * @className ToString
 * @date 2021/11/21 11:41 上午
 * @desrription 这是类的描述信息
 */
public class ToString {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
