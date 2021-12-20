package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @Description: JDK实例化
 * @Author: PhilLee
 * @Date: 2021/12/16 14:25
 * <p>
 * 1 首先通过 beanDefinition 获取 Class 信息，这个 Class 信息是在 Bean 定义的时候传递进去的。
 * 2 接下来判断 ctor 是否为空，如果为空则是无构造函数实例化，否则就是需要有构造函数的实例化。
 * 3 这里我们重点关注有构造函数的实例化，实例化方式为 clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);，
 * 把入参信息传递给 newInstance 进行实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();

        try {
            if (Objects.nonNull(constructor)) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);

            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }

}

