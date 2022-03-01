package com.phillee.springframework.beans.factory.config;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.BeanFactory;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/20 12:36
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /***
     * @Description: 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     * @Param: [java.lang.Object, java.lang.String]
     * @Return: java.lang.Object
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /***
     * @Description: 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     * @Param: [java.lang.Object, java.lang.String]
     * @Return: java.lang.Object
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
