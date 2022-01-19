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

/**
 * @Description: 测试类
 * @Author: PhilLee
 * @Date: 2021/12/10 11:05
 */
public class MethodTest {

    @Test
    public void test_BeanFactory() {

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 userDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5.UserService 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/java/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/small-spring-step-05/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }

    @Test
    public void test_xml() {

        // 1, 初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2, 读取配置文件、注册bean
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        definitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 3, 获取bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());

    }

//    /**
//     * @Description: 验证有构造函数实例化
//     * @Param: []
//     * @Return: void
//     */
//    @Test
//    public void test_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<UserService> userServiceClass = UserService.class;
//
//        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
//
//        UserService userService = declaredConstructor.newInstance("xxx");
//
//        System.out.println(userService);
//    }
//
//    /**
//     * @Description: 获取构造函数信息
//     * @Param: []
//     * @Return: void
//     */
//    @Test
//    public void test_parameterTypes() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
//        Class<UserService> userServiceClass = UserService.class;
//
//        Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();
//        Constructor<?> constructor = declaredConstructors[0];
//
//        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
//
//        UserService userService = declaredConstructor.newInstance("xxx");
//
//        System.out.println(userService);
//    }
//
//    /**
//     * @Description: cglib实例化
//     * @Param: []
//     * @Return: void
//     */
//    @Test
//    public void test_cglib() {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserService.class);
//        enhancer.setCallback(new NoOp() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        });
//
//        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"xxx"});
//        System.out.println(o);
//    }


}