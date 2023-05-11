package cn.un1ink.springframework.beans.factory;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.un1ink.springframework.beans.factory.config.BeanDefinition;
import cn.un1ink.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
