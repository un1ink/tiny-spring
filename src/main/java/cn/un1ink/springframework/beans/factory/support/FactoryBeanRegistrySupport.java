package cn.un1ink.springframework.beans.factory.support;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.FactoryBean;
import cn.un1ink.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();


    protected Object getCacheObjectForFactoryBean(String beanName) {
        return this.factoryBeanObjectCache.get(beanName);
    }

    protected Object getObjectFromFactoryBean(FactoryBean<?> factory, String beanName){
        if(factory.isSingleton()){
            synchronized (getSingletonMutex()){
                Object object = this.factoryBeanObjectCache.get(beanName);
                if(object == null){
                    object = doGetObjectFromFactoryBean(factory, beanName);
                    this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));

                    System.out.println(beanName+ " 被放入factoryBeanObjectCache池中");
                }
                return (object != NULL_OBJECT ? object : null);
            }

        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(FactoryBean<?> factory, String beanName){
        Object object;
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }


}
