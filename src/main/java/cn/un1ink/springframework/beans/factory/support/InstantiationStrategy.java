package cn.un1ink.springframework.beans.factory.support;

import cn.un1ink.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);
}
