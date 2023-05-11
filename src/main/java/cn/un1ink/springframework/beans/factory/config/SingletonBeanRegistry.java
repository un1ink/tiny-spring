package cn.un1ink.springframework.beans.factory.config;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    void registerSingleton(String beanName, Object singletonObject);



}
