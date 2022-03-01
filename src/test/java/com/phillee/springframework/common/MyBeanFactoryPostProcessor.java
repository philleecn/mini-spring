package com.phillee.springframework.common;

import com.phillee.springframework.beans.PropertyValue;
import com.phillee.springframework.beans.PropertyValues;
import com.phillee.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Description: 实现BeanFactoryPostProcessor
 * @Author: PhilLee
 * @Date: 2022/2/22 23:50
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
