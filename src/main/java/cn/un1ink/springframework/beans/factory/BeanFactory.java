package cn.un1ink.springframework.beans.factory;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
