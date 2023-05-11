package cn.un1ink.springframework.context;

import cn.un1ink.springframework.beans.BeansException;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     *
     * @throws BeansException
     *
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
