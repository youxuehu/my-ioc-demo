package com.tiger.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author youxuehu
 * @version v1.0
 * @className Value
 * @date 2021/11/7 8:30 下午
 * @desrription 这是类的描述信息
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
    String value() default "";
}
