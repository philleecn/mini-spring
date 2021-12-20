package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @Description: cglib实例化
 * @Author: PhilLee
 * @Date: 2021/12/16 15:01
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(
                new NoOp() {
                    @Override
                    public int hashCode() {
                        return super.hashCode();
                    }
                }
        );

        if (Objects.isNull(constructor)) return enhancer.create();

        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
