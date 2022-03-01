package com.phillee.springframework.beans.factory.config;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/20 12:39
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
