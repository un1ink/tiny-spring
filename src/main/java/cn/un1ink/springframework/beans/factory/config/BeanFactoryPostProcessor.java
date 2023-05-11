package cn.un1ink.springframework.beans.factory.config;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
