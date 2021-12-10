package com.phillee.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Bean工厂：注册Bean、获取Bean
 * @Author: PhilLee
 * @Date: 2021/12/10 10:49
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    //获取bean
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    //注册bean
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
