package com.phillee.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.PropertyValue;
import com.phillee.springframework.beans.factory.config.BeanDefinition;
import com.phillee.springframework.beans.factory.config.BeanReference;
import com.phillee.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.phillee.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.phillee.springframework.core.io.Resource;
import com.phillee.springframework.core.io.ResourceLoader;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 解析XML处理Bean注册
 * @Author: PhilLee
 * @Date: 2022/1/18 20:56
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... location) throws BeansException {
        for (String s : location) {
            loadBeanDefinitions(s);
        }
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        NodeList childNodes = XmlUtil.readXML(inputStream).getDocumentElement().getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            //判断元素
            if (!(childNodes.item(i) instanceof Element)) continue;

            //判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            Class<?> clazz = Class.forName(bean.getAttribute("class"));

            //优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            //定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            //读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {

                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;

                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                //解析标签property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                //获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                //创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            if (getRegistry().containsBeanDefinition(beanName)) throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");

            //注册beanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }

    }
}
