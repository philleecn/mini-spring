package com.phillee.springframework.beans.factory;

import com.phillee.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/20 12:32
 */
public interface ListableBeanFactory extends BeanFactory{

    /***
     * @Description: 按照类型返回bean实例
     * @Param: [java.lang.Class<T>]
     * @Return: java.util.Map<java.lang.String,T>
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /***
     * @Description: 返回注册表中所有的bean名称
     * @Param: []
     * @Return: java.lang.String[]
     */
    String[] getBeansDefinitionNames();

}
