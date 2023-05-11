package cn.un1ink.springframework.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.BeanFactory;
import cn.un1ink.springframework.beans.factory.FactoryBean;
import cn.un1ink.springframework.beans.factory.config.BeanDefinition;
import cn.un1ink.springframework.beans.factory.config.BeanPostProcessor;
import cn.un1ink.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.un1ink.springframework.beans.factory.config.SingletonBeanRegistry;
import cn.un1ink.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {

        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // bean对象已存在于一级缓存中
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name) ;
    }


    /**
     * FactoryBean对象还需要放入factoryBeanObjectCache缓存中，主要避免获取factoryBean对象时
     */
    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
//        return beanInstance;
        if(!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        // 从factoryBeanObjectCache中尝试获取bean对象
        System.out.println("从factoryBeanObjectCache中尝试获取bean对象" + beanName);
        Object object = getCacheObjectForFactoryBean(beanName);

        if(object == null) {
            // factoryBeanObjectCache中没有，则创建
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean,beanName);

        }
        System.out.println("doGetObjectFromFactoryBean +'"+ beanName+"' is FactoryBean");
        return object;
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        synchronized (this.beanPostProcessors) {
            // Remove from old position, if any
            this.beanPostProcessors.remove(beanPostProcessor);
            // Add to end of list
            this.beanPostProcessors.add(beanPostProcessor);
        }
    }

    public List<BeanPostProcessor> getBeanPostProcessors(){
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }

}
