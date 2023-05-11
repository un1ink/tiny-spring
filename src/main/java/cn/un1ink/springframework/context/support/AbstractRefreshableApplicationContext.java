package cn.un1ink.springframework.context.support;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.un1ink.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @description: 抽象可刷新上下文应用，获取Bean工厂和加载资源
 * @author：un1ink
 * @date: 2023/5/2
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;

    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);
}
