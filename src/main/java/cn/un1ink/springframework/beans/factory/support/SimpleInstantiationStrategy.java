package cn.un1ink.springframework.beans.factory.support;

import cn.un1ink.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();

        try {
            if(null != ctor) {
                Class<?>[] types = ctor.getParameterTypes();

                Object o = clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
                return o;
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
