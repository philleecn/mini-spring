package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.BeanFactory;
import com.phillee.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @Description: 抽象类定义模版方法
 * @Author: PhilLee
 * @Date: 2021/12/11 19:33
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

}
