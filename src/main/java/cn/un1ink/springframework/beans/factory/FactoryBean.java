package cn.un1ink.springframework.beans.factory;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;
    Class<?> getObjectType();

    boolean isSingleton();

}
