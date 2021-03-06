package com.phillee.springframework.beans.factory;

import com.phillee.springframework.beans.BeansException;

/**
 * @Description: Bean工厂：注册Bean、获取Bean
 * @Author: PhilLee
 * @Date: 2021/12/10 10:49
 */
public interface BeanFactory {

    //获取bean
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
