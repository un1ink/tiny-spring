package cn.un1ink.springframework.beans.factory.config;

import cn.un1ink.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";


    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
