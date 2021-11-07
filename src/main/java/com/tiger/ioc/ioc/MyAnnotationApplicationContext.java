package com.tiger.ioc.ioc;

import com.tiger.ioc.annotation.Autowired;
import com.tiger.ioc.annotation.Component;
import com.tiger.ioc.annotation.Qualifier;
import com.tiger.ioc.annotation.Value;
import org.apache.commons.lang.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterNamesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author youxuehu
 * @version v1.0
 * @className MyAnnoatationApplicationContext
 * @date 2021/11/7 7:09 下午
 * @desrription 这是类的描述信息
 */
public class MyAnnotationApplicationContext {

    private final String basePackage;

    private final Map<String, Object> ioc = new HashMap<String, Object>();

    private Set<BeanDefinition> beanDefinitionList = new HashSet<BeanDefinition>();

    public MyAnnotationApplicationContext(String basePackage) {
        this.basePackage = basePackage;
        this.scan();
        this.createObject(beanDefinitionList);
        this.autowiredObject(beanDefinitionList);
    }

    private void autowiredObject(Set<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            Class<?> clazz = beanDefinition.getClazz();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {

                try {
                    Autowired autowiredAnnotation = declaredField.getAnnotation(Autowired.class);
                    if (autowiredAnnotation != null) {
                        // byName
                        Qualifier qualifierAnnotation = declaredField.getAnnotation(Qualifier.class);
                        if (qualifierAnnotation != null) {
                            String value = qualifierAnnotation.value();
                            Object bean = getBean(value);
                            String fieldName = declaredField.getName();
                            String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                            Method method = clazz.getMethod(methodName, declaredField.getType());
                            method.invoke(getBean(beanDefinition.getBeanName()), bean);
                        } else {
                            // byType
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Set<BeanDefinition> scan() {
        Reflections reflections = new Reflections(basePackage, Arrays.asList(
                new SubTypesScanner(false), // 允许getAllTypes获取所有object的子类， 不设置为false则getAllTypes会报错， 默认为true
                new MethodParameterNamesScanner(),//设置方法参数名称 扫描器，否则调用getConstructorParamNames会报错
                new MethodAnnotationsScanner(),//设置方法注解 扫描器，否则getConstructorsAnnotationWith,getMethodsAnnotationWith会报错
                new TypeAnnotationsScanner()//设置类注解扫描器，否则getTypeAnnotationWith会报错
        ));
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Component.class);

        for (Class<?> clazz : classes) {
            String simpleName = clazz.getSimpleName();
            Component component = clazz.getAnnotation(Component.class);

            String beanName = component.value();
            if (StringUtils.isBlank(beanName)) {
                beanName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
            }
            BeanDefinition beanDefinition = new BeanDefinition(beanName, clazz);
            beanDefinitionList.add(beanDefinition);

        }
        return beanDefinitionList;
    }

    public void createObject(Set<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            try {
                String beanName = beanDefinition.getBeanName();
                Class<?> clazz = beanDefinition.getClazz();
                Object object = clazz.getConstructor().newInstance();
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field field : declaredFields) {
                    Value valueAnnotation = field.getAnnotation(Value.class);
                    if (valueAnnotation == null) {
                        continue;
                    }
                    String value = valueAnnotation.value();
                    if (StringUtils.isBlank(value)) {
                        continue;

                    }
                    String fieldName = field.getName();
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method method = clazz.getMethod(methodName, field.getType());
                    Object val = null;

                    switch (field.getType().getName()) {
                        case "java.lang.String":
                            val = value;
                            break;
                        case "java.lang.Integer":
                            val = Integer.valueOf(value);
                            break;
                        case "java.lang.Float":
                            val = Float.valueOf(value);
                            break;
                        case "java.lang.Double":
                            val = Double.valueOf(value);
                            break;
                    }
                    method.invoke(object, val);
                }
                ioc.put(beanName, object);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String beanName) {
        return ioc.get(beanName);
    }
}
