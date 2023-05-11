package cn.un1ink.springframework.beans.factory.support;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.un1ink.springframework.beans.factory.HierarchicalBeanFactory;
import cn.un1ink.springframework.beans.factory.config.BeanDefinition;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory, Serializable {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null) {
            throw new BeansException("no bean named '" + beanName + "' is defined.");
        }
        return beanDefinition;
    }

    /**对所有beanDefinitionMap中对象执行getBean操作，将bean对象并注入缓存中*/
    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> res = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) ->{
            Class beanClass = beanDefinition.getBeanClass();
            if(type.isAssignableFrom(beanClass)) {
                res.put(beanName, (T) getBean(beanName));
            }
        });
        return res;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }


}
