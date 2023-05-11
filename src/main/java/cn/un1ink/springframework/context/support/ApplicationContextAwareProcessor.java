package cn.un1ink.springframework.context.support;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.config.BeanPostProcessor;
import cn.un1ink.springframework.context.ApplicationContext;
import cn.un1ink.springframework.context.ApplicationContextAware;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/3
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
