package cn.un1ink.springframework.context.support;

import cn.un1ink.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.un1ink.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description: 上下文中对xml配置信息的加载
 * @author：un1ink
 * @date: 2023/5/2
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if(null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
