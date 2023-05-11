package cn.un1ink.springframework.beans.factory;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.un1ink.springframework.core.io.DefaultResourceLoader;
import cn.un1ink.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties", e);
        }

    }

    public void setLocation(String location) {
        this.location = location;
    }
}
