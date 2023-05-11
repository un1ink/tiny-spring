package cn.un1ink.springframework.test.common;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.PropertyValue;
import cn.un1ink.springframework.beans.PropertyValues;
import cn.un1ink.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.un1ink.springframework.beans.factory.config.BeanDefinition;
import cn.un1ink.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}