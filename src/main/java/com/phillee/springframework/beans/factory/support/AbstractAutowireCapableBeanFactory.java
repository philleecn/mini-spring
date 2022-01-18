package com.phillee.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.PropertyValue;
import com.phillee.springframework.beans.PropertyValues;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.config.BeanReference;
import sun.swing.BeanInfoUtils;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @Description: 实例化bean
 * @Author: PhilLee
 * @Date: 2021/12/11 20:14
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {

        Object bean = null;

        try {

            bean = createBeanInstance(beanName, beanDefinition, args);

            //给bean填充属性
            applyPropertyValues(beanName, beanDefinition, bean);

        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);

        return bean;
    }

    /***
     * @Description: Bean属性填充
     * @Param: [java.lang.String, com.phillee.springframework.beans.factory.config.BeanDefinition, java.lang.Object]
     * @Return: void
     */
    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();

            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A依赖B，获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws NoSuchMethodException {
        Constructor constructorToUse = null;

        Class<?> beanClass = beanDefinition.getBeanClass();

        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor<?> constructor : declaredConstructors) {
            if (Objects.nonNull(args) && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
