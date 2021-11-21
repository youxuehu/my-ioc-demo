package com.tiger.ioc;

import com.tiger.ioc.ioc.MyAnnotationApplicationContext;

/**
 * @author youxuehu
 * @version v1.0
 * @className IocMain
 * @date 2021/11/7 7:21 下午
 * @desrription 这是类的描述信息
 */
public class IocMain {

    public static void main(String[] args) {

        MyAnnotationApplicationContext app = new MyAnnotationApplicationContext("com.tiger.ioc.entity");

        Object executionRecord = app.getBean("executionRecord");
        System.out.println(executionRecord);
    }
}
