package com.tiger.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author youxuehu
 * @version v1.0
 * @className Qualifier
 * @date 2021/11/7 9:20 下午
 * @desrription 这是类的描述信息
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Qualifier {
    String value();
}
