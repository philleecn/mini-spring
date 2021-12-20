package com.phillee.springframework.bean.com.phillee.springframework;

import com.phillee.springframework.bean.UserService;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.support.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;

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

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "xxx");
        userService.queryUserInfo();

    }

    /**
     * @Description: 验证有构造函数实例化
     * @Param: []
     * @Return: void
     */
    @Test
    public void test_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;

        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);

        UserService userService = declaredConstructor.newInstance("xxx");

        System.out.println(userService);
    }

    /**
     * @Description: 获取构造函数信息
     * @Param: []
     * @Return: void
     */
    @Test
    public void test_parameterTypes() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<UserService> userServiceClass = UserService.class;

        Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];

        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());

        UserService userService = declaredConstructor.newInstance("xxx");

        System.out.println(userService);
    }

    /**
     * @Description: cglib实例化
     * @Param: []
     * @Return: void
     */
    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"xxx"});
        System.out.println(o);
    }

}
