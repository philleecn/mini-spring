package com.phillee.springframework.beans.factory.config;

import com.phillee.springframework.beans.PropertyValue;
import com.phillee.springframework.beans.PropertyValues;
import lombok.Data;

/**
 * @Description: 定义Bean的实例化信息
 * @Author: PhilLee
 * @Date: 2021/12/10 10:00
 */
@Data
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
}
