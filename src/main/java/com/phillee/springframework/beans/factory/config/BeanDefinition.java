package com.phillee.springframework.beans.factory.config;

/**
 * @Description: 定义Bean的实例化信息
 * @Author: PhilLee
 * @Date: 2021/12/10 10:00
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
