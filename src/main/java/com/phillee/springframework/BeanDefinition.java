package com.phillee.springframework;

/**
 * @Description: 定义Bean的实例化信息
 * @Author: PhilLee
 * @Date: 2021/12/10 10:00
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
