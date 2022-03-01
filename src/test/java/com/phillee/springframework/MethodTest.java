package com.phillee.springframework;

import cn.hutool.core.io.IoUtil;
import com.phillee.springframework.bean.UserDao;
import com.phillee.springframework.bean.UserService;
import com.phillee.springframework.beans.PropertyValue;
import com.phillee.springframework.beans.PropertyValues;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.config.BeanReference;
import com.phillee.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.phillee.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.phillee.springframework.common.MyBeanFactoryPostProcessor;
import com.phillee.springframework.common.MyBeanPostProcessor;
import com.phillee.springframework.context.support.ClassPathXmlApplicationContext;
import com.phillee.springframework.core.io.DefaultResourceLoader;
import com.phillee.springframework.core.io.Resource;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sun.misc.Version.println;

/**
 * @Description: 测试类
 * @Author: PhilLee
 * @Date: 2021/12/10 11:05
 */
public class MethodTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_Template() {
        String s = "aaaaa[部门]bbbbb[部门]";
        String replace = s.replaceAll("[部门]", "人力部");
        System.out.println(replace);

    }
}
