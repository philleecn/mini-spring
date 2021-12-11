package com.phillee.springframework.bean.com.phillee.springframework;

import com.phillee.springframework.bean.UserService;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: PhilLee
 * @Date: 2021/12/10 11:05
 */
public class MethodTest {

    @Test
    public void testBeanFactory() {

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo("1");

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo("2");

    }

}
