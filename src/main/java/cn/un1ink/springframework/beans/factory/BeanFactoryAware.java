package cn.un1ink.springframework.beans.factory;

import cn.un1ink.springframework.beans.BeansException;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/3
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
