package com.phillee.springframework.bean.com.phillee.springframework;

import com.phillee.springframework.BeanDefinition;
import com.phillee.springframework.BeanFactory;
import com.phillee.springframework.bean.UserService;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: PhilLee
 * @Date: 2021/12/10 11:05
 */
public class MethodTest {

    @Test
    public void testBeanFactory() {

        //初始化bean
        BeanFactory beanFactory = new BeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
