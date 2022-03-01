package com.phillee.springframework.beans.factory;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.config.BeanPostProcessor;
import com.phillee.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/20 12:11
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
