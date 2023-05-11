package cn.un1ink.springframework.beans.factory.support;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.core.io.Resource;
import cn.un1ink.springframework.core.io.ResourceLoader;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
