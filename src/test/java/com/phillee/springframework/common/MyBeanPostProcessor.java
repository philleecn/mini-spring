package com.phillee.springframework.common;

import com.phillee.springframework.bean.UserService;
import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description: 实现BeanPostProcessor
 * @Author: PhilLee
 * @Date: 2022/2/22 23:51
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
